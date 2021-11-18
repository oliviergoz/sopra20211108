package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import formationJpa.entity.Formateur;
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

	@Override
	public List<Formation> findWithModules() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em.createNamedQuery("Formation.findWithModules", Formation.class);
		List<Formation> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public Formation findByIdWithModules(Long id) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em.createNamedQuery("Formation.findByIdWithModules", Formation.class);
		query.setParameter("id", id);
		Formation formation = null;
		formation = query.getSingleResult();
		em.close();
		return formation;
	}

	@Override
	public List<Formation> findByReferent(Formateur formateur) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Formation> query = em.createNamedQuery("Formation.findByReferent", Formation.class);
		query.setParameter("referent", formateur);
		query.setHint("org.hibernate.cacheble", true);
		List<Formation> list = query.getResultList();
		em.close();
		return list;
	}
}
