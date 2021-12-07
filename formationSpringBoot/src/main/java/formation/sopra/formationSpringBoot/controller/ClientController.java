package formation.sopra.formationSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import formation.sopra.formationSpringBoot.entities.Civilite;
import formation.sopra.formationSpringBoot.entities.Client;
import formation.sopra.formationSpringBoot.services.ClientService;

@Controller
@RequestMapping("/client")
public class ClientController {

	@Autowired
	private ClientService clientService;

	@GetMapping("")
	public ModelAndView List() {
		ModelAndView modelAndView = new ModelAndView("client/list");
		modelAndView.addObject("clients", clientService.allClient());
		return modelAndView;
	}

	@GetMapping("/edit")
	public ModelAndView edit(@RequestParam(name = "id") Long id) {
		return goEdit(clientService.byId(id));
	}

	@GetMapping("/add")
	public ModelAndView add() {
		return goEdit(new Client());
	}

	private ModelAndView goEdit(Client client) {
		ModelAndView modelAndView = new ModelAndView("client/edit");
		modelAndView.addObject("civilites", Civilite.values());
		modelAndView.addObject("client", client);
		return modelAndView;
	}

	@GetMapping("/delete")
	public ModelAndView delete(@RequestParam(name = "id") Long id) {
		clientService.delete(id);
		return new ModelAndView("redirect:/client");
	}

	@PostMapping("/save")
	public ModelAndView save(@Valid @ModelAttribute("client") Client client, BindingResult br) {
		if (br.hasErrors()) {
			return goEdit(client);
		}
		clientService.create(client);
		return new ModelAndView("redirect:/client");
	}
}
