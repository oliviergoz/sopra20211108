package formationSpring;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import formationSpring.bean.Guitare;
import formationSpring.bean.Instrument;
import formationSpring.bean.Musicien;
import formationSpring.config.AppConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class TestAspect {

	@Autowired
	@Qualifier("guitariste")
	Musicien guitariste;
	@Autowired
	@Qualifier("saxophone")
	Instrument saxo;

//	@Test
//	public void testAspectGetInstrument() {
//		guitariste.getInstrument();
//	}

	@Test
	public void testSetInstrument() {
		assertTrue(guitariste.getInstrument() instanceof Guitare);
		guitariste.setInstrument(saxo);
		assertTrue(guitariste.getInstrument() instanceof Guitare);
	}
}
