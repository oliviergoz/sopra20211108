package exoJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import exoJpa.entity.Client;

@Repository
public class DaoClientJpaImpl implements DaoClient {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Client> findAll() {
		TypedQuery<Client> query = em.createQuery("from Client o", Client.class);
		List<Client> list = query.getResultList();
		return list;
	}

	@Override
	public Client findByKey(Long key) {
		Client obj = em.find(Client.class, key);
		return obj;
	}

	@Override
	@Transactional
	public void insert(Client obj) {
		em.persist(obj);
	}

	@Override
	@Transactional
	public Client update(Client obj) {
		return em.merge(obj);
	}

	@Override
	@Transactional
	public void delete(Client obj) {
		deleteByKey(obj.getId());
	}

	@Override
	@Transactional
	public void deleteByKey(Long key) {
		Client objManaged = em.find(Client.class, key);
		objManaged.getCommandes().forEach(commande -> {
			commande.setClient(null);
			em.merge(commande);
		});
		em.remove(objManaged);
	}

	public Client findByKeyWithCommandes(Long key) {
		TypedQuery<Client> query = em.createQuery("select c from Client c left join fetch c.commandes where c.id=:key",
				Client.class);
		query.setParameter("key", key);
		Client client = query.getSingleResult();
		return client;
	}

	public List<Client> findAllWithCommandes() {
		TypedQuery<Client> query = em.createQuery("select distinct c from Client c left join fetch c.commandes",
				Client.class);
		List<Client> clients = query.getResultList();
		return clients;
	}

}
