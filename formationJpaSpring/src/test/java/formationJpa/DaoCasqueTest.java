package formationJpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import formationJpa.dao.DaoCasque;
import formationJpa.entity.Casque;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/application-context.xml" })
public class DaoCasqueTest {

	@Autowired
	private DaoCasque daoCasque;

	@Test
	public void DaoCasqueInjectionTest() {
		assertNotNull(daoCasque);
	}

	@Test
	public void insertTest() {
		Casque casque = new Casque();
		casque.setMarque("sony");
		daoCasque.insert(casque);
		assertNotNull(daoCasque.findByKey(casque.getId()));
		daoCasque.delete(casque);
		assertNull(daoCasque.findByKey(casque.getId()));
	}

}
