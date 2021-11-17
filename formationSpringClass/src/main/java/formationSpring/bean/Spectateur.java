package formationSpring.bean;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class Spectateur {

	@Autowired
	@Qualifier("guitariste")
	private Musicien secondMusicien;

	@Pointcut("execution(* formationSpring.bean.Musicien.jouer())")
	public void jouerMusicien() {

	}

	@Pointcut("execution(* formationSpring.bean.Guitariste.jouer())")
	public void jouerGuitariste() {

	}

	@Pointcut("execution(* formationSpring.bean.Saxophoniste.jouer())")
	public void jouerSaxophoniste() {

	}

	@Before("jouerSaxophoniste()")
	public void publicInstallation() {
		System.out.println("le public s'installe");
	}

	@AfterReturning(pointcut = "jouerMusicien()")
	public void applaudir() {
		System.out.println("bravo");
	}

	@AfterThrowing(pointcut = "jouerMusicien()")
	public void siffler() {
		System.out.println("pas content");
	}

	@After("jouerSaxophoniste()")
	public void partir() {
		secondMusicien.jouer();
		System.out.println("le public part");
	}
}
