package formationJpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoFormationFactory;
import formationJpa.entity.Formation;
import formationJpa.util.Context;

public class AppTest {
	public static void main(String[] args) {
		DaoFormation daoFormation = DaoFormationFactory.getInstance();

		Formation f = new Formation();
		f.setId(10L);
		f.setNom("java");
		daoFormation.insert(f);

		System.out.println(daoFormation.findByKey(10L));
		System.out.println(daoFormation.findByKey(100L));

		// daoFormation.deleteByKey(10L);
		daoFormation.delete(f);
		System.out.println(daoFormation.findByKey(10L));
		// a faire en dernier
		Context.destroy();
	}
}
