package formation.sopra.formationSpringBoot.services;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import formation.sopra.formationSpringBoot.entities.Client;
import formation.sopra.formationSpringBoot.entities.Role;
import formation.sopra.formationSpringBoot.entities.User;
import formation.sopra.formationSpringBoot.exceptions.ClientException;
import formation.sopra.formationSpringBoot.repositories.ClientRepository;
import formation.sopra.formationSpringBoot.repositories.CommandeRepository;
import formation.sopra.formationSpringBoot.repositories.UserRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public Client save(Client client) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty()) {
			User user = client.getUser();
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			user.setRoles(Arrays.asList(Role.ROLE_USER));
			user.setEnable(true);
			userRepository.save(user);
			client = clientRepository.save(client);
			return client;
		} else {
			throw new ClientException();
		}
	}

//	public void delete(Client client) {
//		Client clientEnBase = clientRepository.findByIdWithCommandes(client.getId()).orElseThrow(ClientException::new);
//		clientEnBase.getCommandes().forEach(commande -> {
//			commande.setClient(null);
//			commandeRepository.save(commande);
//		});
//		clientRepository.delete(clientEnBase);
//	}

	public void delete(Client client) {
		Client clientEnBase = clientRepository.findById(client.getId()).orElseThrow(ClientException::new);
		commandeRepository.removeClientFromCommandeByClient(clientEnBase);
		clientRepository.delete(clientEnBase);
	}

	public void delete(Long id) {
		delete(clientRepository.findById(id).orElseThrow(ClientException::new));
	}

	public List<Client> allClient() {
		return clientRepository.findAll();
	}

	public Page<Client> clientFirstPage(int size) {
		Pageable pageable = PageRequest.of(0, size);
		return clientRepository.findAll(pageable);
	}

	public Page<Client> clientNextPage(Page<Client> page) {
		return clientRepository.findAll(page.nextOrLastPageable());
	}

	public Page<Client> clientPreviousPage(Page<Client> page) {
		return clientRepository.findAll(page.previousOrFirstPageable());
	}

	public Client byId(Long id) {
		return clientRepository.findByIdWithCommandes(id).orElseThrow(ClientException::new);
	}
}
