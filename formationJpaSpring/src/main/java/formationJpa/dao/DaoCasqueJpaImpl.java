package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import formationJpa.entity.Casque;

@Repository
public class DaoCasqueJpaImpl implements DaoCasque {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Casque> findAll() {
		return em.createQuery("from Casque m", Casque.class).getResultList();

	}

	@Override
	public Casque findByKey(Long key) {
		Casque casque = em.find(Casque.class, key);
		return casque;
	}

	@Override
	@Transactional
	public void insert(Casque obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public void update(Casque obj) {
		em.merge(obj);
	}

	@Override
	@Transactional
	public void delete(Casque obj) {
		em.remove(em.merge(obj));
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		em.remove(em.find(Casque.class, key));
	}

}
