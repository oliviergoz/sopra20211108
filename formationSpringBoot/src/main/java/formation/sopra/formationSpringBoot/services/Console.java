package formation.sopra.formationSpringBoot.services;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

@Service
public class Console implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hello world");
	}

}
