package exoJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import exoJpa.Context;
import exoJpa.entity.Commande;
import exoJpa.entity.Produit;

public class DaoCommandeJpaImpl implements DaoCommande {

	@Override
	public List<Commande> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Commande> query = em.createQuery("from Commande o", Commande.class);
		List<Commande> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public Commande findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Commande obj = em.find(Commande.class, key);
		em.close();
		return obj;
	}

	@Override
	public void insert(Commande obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		obj.getLignesCommandes().forEach(lc -> {
			em.persist(lc);
		});
		tx.commit();
		em.close();

	}

	@Override
	public void update(Commande obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(obj);
		tx.commit();
		em.close();

	}

	@Override
	public void delete(Commande obj) {
		deleteByKey(obj.getNumero());

	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Commande commande = em.find(Commande.class, key);
		commande.getLignesCommandes().forEach(lc -> {
			em.remove(lc);
		});
		em.remove(commande);
		tx.commit();
		em.close();
	}

}
