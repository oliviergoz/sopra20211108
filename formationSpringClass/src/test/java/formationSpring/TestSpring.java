package formationSpring;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import formationSpring.bean.Musicien;
import formationSpring.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TestSpring {

	@Autowired
	@Qualifier("guitariste")
	private Musicien musicien;

	@Test
	public void testInjectionMusicien() {
		assertNotNull(musicien);
	}
}
