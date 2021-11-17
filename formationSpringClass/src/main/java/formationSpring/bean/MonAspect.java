package formationSpring.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
//@Aspect
public class MonAspect {

//	@Pointcut("execution(formationSpring.bean.Instrument formationSpring.bean.Musicien.getInstrument())")
//	public void pointcut() {
//
//	}
//
//	@Before("pointcut()")
//	public void methode1() {
//		System.out.println("methode1");
//	}
//
//	@AfterReturning(pointcut = "pointcut()", returning = "instrument")
//	public void methode2AfterReturning(Instrument instrument) {
//		System.out.println("methode2:" + instrument);
//	}
//
//	@AfterThrowing(pointcut = "pointcut()")
//	public void methode3AfterThrowing() {
//		System.out.println("execpetion=>methode3");
//	}
//
//	@After("pointcut()")
//	public void methode4After() {
//		System.out.println("methode4");
//	}
//
//	@Around("pointcut()")
//	public Object arround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//
//		System.out.println("dans around");
//		System.out.println("lancement de la methode interceptee");
//		// declenche l'execution de la methode demandée
//		Object o = proceedingJoinPoint.proceed();
//
//		return o;
//
//	}
//
//	@Around("execution(* formationSpring.bean.*.setInstrument(..))&& args(instrument)")
//	public void aroundSetInstrument(ProceedingJoinPoint pJP, Instrument instrument) throws Throwable {
//		System.out.println("setInstrument:" + instrument);
//		if (instrument.getClass().getSimpleName().equals("Saxophone")) {
//			System.out.println("instrument invalide");
//		} else {
//			System.out.println("proceed set");
//			pJP.proceed();
//		}
//	}
}
