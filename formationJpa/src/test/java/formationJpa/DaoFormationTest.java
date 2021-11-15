package formationJpa;

import static org.junit.Assert.*;

import java.time.LocalDate;

import javax.persistence.NoResultException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoFormationFactory;
import formationJpa.entity.Formation;
import formationJpa.util.Context;

public class DaoFormationTest {

	private DaoFormation daoFormation;

	@BeforeClass
	public static void startTest() {

	}

	@AfterClass
	public static void stopTest() {
		Context.destroy();
	}

	@Before
	public void beforeTest() {
		daoFormation = DaoFormationFactory.getInstance();
	}

	@After
	public void afterTest() {

	}

	@Test
	public void testFindWithModules() {

	}

	@Test
	public void testFindByIdWithModules() {
	}

	@Test(expected = NoResultException.class)
	public void testFindByIdWithModulesFail() {
		daoFormation.findByIdWithModules(99999999L);
	}

	@Test
	public void testFindByReferent() {
	}

	@Test
	public void testFindAll() {
	}

	@Test
	public void testFindByKey() {
	}

	private Formation createFormation() {
		Formation formation = new Formation();
		formation.setDate(LocalDate.now());
		formation.setNom("test");
		return formation;
	}

	@Test
	public void testInsert() {
		Formation formation = createFormation();
		formation = daoFormation.findByKey(formation.getId());
		assertNotNull(formation);
		assertEquals("test", formation.getNom());
		assertEquals(LocalDate.now(), formation.getDate());
		daoFormation.delete(formation);
	}

	@Test
	public void testUpdate() {
	}

	@Test
	public void testDelete() {
	}

	@Test
	public void testDeleteByKey() {
	}

}
