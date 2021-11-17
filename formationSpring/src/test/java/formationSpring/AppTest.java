package formationSpring;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AppTest {
	private static ClassPathXmlApplicationContext ctx;

	@BeforeClass
	public static void initSpringContext() {
		ctx = new ClassPathXmlApplicationContext("application-context.xml");
	}

	@AfterClass
	public static void closeSpringContext() {
		ctx.close();
	}

	@Test
	public void test() {

		Guitare guitare = (Guitare) ctx.getBean("guitare");
		assertNotNull(guitare);
//		guitare = ctx.getBean(Guitare.class);
		guitare = ctx.getBean("guitare", Guitare.class);
		assertNotNull(guitare);
		assertEquals("fender", guitare.getMarque());
		Guitariste guitariste = ctx.getBean(Guitariste.class);
		assertNotNull(guitariste);
		assertNotNull(guitariste.getInstrument());
		assertEquals("fender", guitariste.getInstrument().getMarque());
	}

	@Test
	public void TestCouplageFaible() {
		Musicien musicien = ctx.getBean(Musicien.class);
		System.out.println(musicien);
		System.out.println(musicien.getInstrument());
	}
}
