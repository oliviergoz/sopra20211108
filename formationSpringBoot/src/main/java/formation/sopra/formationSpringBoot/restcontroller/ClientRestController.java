package formation.sopra.formationSpringBoot.restcontroller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.formationSpringBoot.entities.Client;
import formation.sopra.formationSpringBoot.entities.JsonViews;
import formation.sopra.formationSpringBoot.services.ClientService;

@RestController
@RequestMapping("/api/client")
public class ClientRestController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientRestController.class);

	@Autowired
	private ClientService clientService;

	@GetMapping("")
	@JsonView(JsonViews.ClientAvecUser.class)
	public List<Client> all() {
		LOGGER.info("execution restClient all()");
		return clientService.allClient();
	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.ClientAvecUser.class)
	public Client byId(@PathVariable("id") Long id) {
		return clientService.byId(id);
	}

	@PostMapping("")
	@JsonView(JsonViews.ClientAvecUser.class)
	@ResponseStatus(code = HttpStatus.CREATED)
	public Client create(@Valid @RequestBody Client client, BindingResult br) {
		return clientService.save(client);
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.ClientAvecUser.class)
	public Client update(@Valid @RequestBody Client client, BindingResult br, @PathVariable("id") Long id) {
		Client clientEnBase = clientService.byId(id);
		clientEnBase.setCivilite(client.getCivilite());
		clientEnBase.setNom(client.getNom());
		clientEnBase.setPrenom(client.getPrenom());
		return clientService.save(clientEnBase);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		clientService.delete(id);
	}

}
