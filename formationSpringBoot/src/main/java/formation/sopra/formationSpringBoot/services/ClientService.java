package formation.sopra.formationSpringBoot.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import formation.sopra.formationSpringBoot.entities.Client;
import formation.sopra.formationSpringBoot.exceptions.ClientException;
import formation.sopra.formationSpringBoot.repositories.ClientRepository;
import formation.sopra.formationSpringBoot.repositories.CommandeRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;
	@Autowired
	private CommandeRepository commandeRepository;

	public Client save(Client client) {
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		Set<ConstraintViolation<Client>> violations = validator.validate(client);
		if (violations.isEmpty()) {
			return clientRepository.save(client);
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
