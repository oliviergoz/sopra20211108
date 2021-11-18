package exoJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import exoJpa.entity.Commande;

@Repository
public class DaoCommandeJpaImpl implements DaoCommande {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Commande> findAll() {
		TypedQuery<Commande> query = em.createQuery("from Commande o", Commande.class);
		List<Commande> list = query.getResultList();
		return list;
	}

	@Override
	public Commande findByKey(Long key) {
		Commande obj = em.find(Commande.class, key);
		return obj;
	}

	@Override
	@Transactional
	public void insert(Commande obj) {
		em.persist(obj);
		obj.getLignesCommandes().forEach(lc -> {
			em.persist(lc);
		});
	}

	@Override
	@Transactional
	public Commande update(Commande obj) {
		obj = em.merge(obj);
		return obj;
	}

	@Override
	@Transactional
	public void delete(Commande obj) {
		deleteByKey(obj.getNumero());

	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		Commande commande = em.find(Commande.class, key);
//		commande.getLignesCommandes().forEach(lc -> {
//			em.remove(lc);
//		});

		Query deleteLigneCommande = em.createQuery("delete from LigneCommande lc where lc.id.commande.numero=:numero");
		deleteLigneCommande.setParameter("numero", key);
		deleteLigneCommande.executeUpdate();
		em.remove(commande);
	}

	public Commande findByKeyWithLignesCommandes(Long key) {
		TypedQuery<Commande> query = em.createNamedQuery("Commande.findByKeyWithLignesCommandes", Commande.class);
		query.setParameter("numero", key);
		// Commande commande = query.getSingleResult();
		Commande commande = null;
		List<Commande> list = query.getResultList();
		if (!list.isEmpty()) {
			commande = list.get(0);
		}
		return commande;
	}

	public List<Commande> findAllWithLignesCommandes() {
		TypedQuery<Commande> query = em.createNamedQuery("Commande.findAllWithLignesCommandes", Commande.class);
		List<Commande> list = query.getResultList();
		return list;
	}

}
