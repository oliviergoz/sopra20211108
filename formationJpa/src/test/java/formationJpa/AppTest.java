package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.entity.Formation;
import formationJpa.util.Context;

public class AppTest {
	public static void main(String[] args) {
		System.out.println(Context.getInstance().getEntityManagerFactory());

		// insert en base
		// em.persist(<entity>);

		// "update"
		// em.merge(<entity>);

		// delete
		// em.remove(<entity>);

		// persist,merge,remove=>gestion transaction

		// findByKey
		// em.find(Class<entity>, key)

		Formation formation = new Formation();
		formation.setId(10L);
		formation.setNom("java");
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();

		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(formation);
		tx.commit();
		em.close();

		formation.setNom("formation java");
		em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		tx = em.getTransaction();
		tx.begin();
		formation = em.merge(formation);
		tx.commit();
		em.close();

		// a faire en dernier
		Context.destroy();
	}
}
