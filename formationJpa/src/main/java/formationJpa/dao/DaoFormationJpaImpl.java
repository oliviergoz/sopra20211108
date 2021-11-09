package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import formationJpa.entity.Formation;
import formationJpa.util.Context;

class DaoFormationJpaImpl implements DaoFormation {
	@Override
	public List<Formation> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		// requete jpql
		TypedQuery<Formation> query = em.createQuery("from Formation f", Formation.class);
		List<Formation> formations = query.getResultList();
		em.close();
		return formations;
	}

	@Override
	public Formation findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Formation f = em.find(Formation.class, key);
		em.close();
		return f;
	}

	@Override
	public void insert(Formation obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public void update(Formation obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(obj);
		tx.commit();
		em.close();

	}

	@Override
	public void delete(Formation obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();

	}

	@Override
	public void deleteByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(Formation.class, key));
		tx.commit();
		em.close();

	}
}
