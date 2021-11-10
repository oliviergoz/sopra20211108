package formationJpa.dao;

import java.util.List;
import formationJpa.entity.Ordinateur;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.util.Context;

public class DaoOrdinateurJpaImpl implements DaoOrdinateur {

	@Override
	public List<Ordinateur> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Ordinateur> query = em.createQuery("from Ordinateur m", Ordinateur.class);
		List<Ordinateur> ordinateurs = query.getResultList();
		em.close();
		return ordinateurs;
	}

	@Override
	public Ordinateur findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Ordinateur ordinateur = em.find(Ordinateur.class, key);
		em.close();
		return ordinateur;
	}

	@Override
	public void insert(Ordinateur obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public void update(Ordinateur obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(obj);
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Ordinateur obj) {
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
		em.remove(em.find(Ordinateur.class, key));
		tx.commit();
		em.close();
	}

}
