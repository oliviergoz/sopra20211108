package exoJpa;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exoJpa.config.AppConfig;
import exoJpa.dao.DaoClient;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class AppTest {

	@Autowired
	private DaoClient daoClient;

	@Test
	public void daoClientInjectionTest() {
		assertNotNull(daoClient);
	}
}
