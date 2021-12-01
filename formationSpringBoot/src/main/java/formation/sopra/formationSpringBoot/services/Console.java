package formation.sopra.formationSpringBoot.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.formationSpringBoot.repositories.UserRepository;

@Service
public class Console implements CommandLineRunner {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		//initPassword();
	}

	private void initPassword() {
		userRepository.findAll().forEach(u -> {
			u.setPassword(passwordEncoder.encode(u.getLogin()));
			userRepository.save(u);
		});
	}

}
