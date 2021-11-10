package formationJpa.dao;

import java.util.List;
import formationJpa.entity.ModuleFormation;
import formationJpa.entity.ModuleFormationKey;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import formationJpa.util.Context;

 class DaoModuleFormationJpaImpl implements DaoModuleFormation {

	@Override
	public List<ModuleFormation> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<ModuleFormation> query = em.createQuery("from ModuleFormation m", ModuleFormation.class);
		List<ModuleFormation> modules = query.getResultList();
		em.close();
		return modules;
	}

	@Override
	public ModuleFormation findByKey(ModuleFormationKey key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		ModuleFormation m = em.find(ModuleFormation.class, key);
		em.close();
		return m;
	}

	@Override
	public void insert(ModuleFormation obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public void update(ModuleFormation obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(obj);
		tx.commit();
		em.close();
	}

	@Override
	public void delete(ModuleFormation obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.merge(obj));
		tx.commit();
		em.close();
	}

	@Override
	public void deleteByKey(ModuleFormationKey key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.remove(em.find(ModuleFormation.class, key));
		tx.commit();
		em.close();
	}

}
