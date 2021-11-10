package formationJpa.dao;

import java.util.List;
import formationJpa.entity.Casque;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.util.Context;

public class DaoCasqueJpaImpl implements DaoCasque {

	@Override
	public List<Casque> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Casque> query = em.createQuery("from Casque m", Casque.class);
		List<Casque> casques = query.getResultList();
		em.close();
		return casques;
	}

	@Override
	public Casque findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Casque casque = em.find(Casque.class, key);
		em.close();
		return casque;
	}

	@Override
	public void insert(Casque obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public void update(Casque obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(obj);
		tx.commit();
		em.close();
	}

	@Override
	public void delete(Casque obj) {
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
		em.remove(em.find(Casque.class, key));
		tx.commit();
		em.close();
	}

}
