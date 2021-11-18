package exoJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import exoJpa.entity.Produit;

@Repository
public class DaoProduitJpaImpl implements DaoProduit {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Produit> findAll() {
		TypedQuery<Produit> query = em.createQuery("from Produit o", Produit.class);
		List<Produit> list = query.getResultList();
		return list;
	}

	@Override
	public Produit findByKey(Long key) {
		Produit obj = em.find(Produit.class, key);
		return obj;
	}

	@Override
	@Transactional
	public void insert(Produit obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Produit update(Produit obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Produit obj) {
		deleteByKey(obj.getId());
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		Produit produit = em.find(Produit.class, key);
		produit.getLignesCommandes().forEach(lc -> {
			em.remove(lc);
		});
		em.remove(produit);
	}

}
