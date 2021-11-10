package formationJpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import formationJpa.entity.Formateur;
import formationJpa.entity.Personne;
import formationJpa.entity.Stagiaire;
import formationJpa.util.Context;

class DaoPersonneJpaImpl implements DaoPersonne {

	@Override
	public List<Personne> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		// requete jpql
		TypedQuery<Personne> query = em.createQuery("from Personne p", Personne.class);
		List<Personne> personnes = query.getResultList();
		em.close();
		return personnes;
	}

	@Override
	public Personne findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Personne personne = em.find(Personne.class, key);
		em.close();
		return personne;
	}

	@Override
	public void insert(Personne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(obj);
		tx.commit();
		em.close();
	}

	@Override
	public void update(Personne obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.merge(obj);
		tx.commit();
		em.close();

	}

	@Override
	public void delete(Personne obj) {
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
		em.remove(em.find(Personne.class, key));
		tx.commit();
		em.close();

	}

	@Override
	public List<Formateur> findAllFormateur() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		TypedQuery<Formateur> query = em.createQuery("from Formateur f", Formateur.class);
		List<Formateur> formateurs = query.getResultList();
		em.close();
		return formateurs;
	}

	@Override
	public List<Stagiaire> findAllStagiaire() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Stagiaire s");
		List<Stagiaire> stagiaires = query.getResultList();
		em.close();
		return stagiaires;
	}

	@Override
	public Formateur findFormateurByID(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Formateur formateur = em.find(Formateur.class, key);
//		System.out.println("execution getFormation");
//		System.out.println(formateur.getFormations());
		em.close();
		return formateur;
	}

}
