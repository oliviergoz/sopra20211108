package formation.sopra.formationSpringBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import formation.sopra.formationSpringBoot.entities.Commande;
import formation.sopra.formationSpringBoot.services.ClientService;
import formation.sopra.formationSpringBoot.services.CommandeService;

@Controller
@RequestMapping("/commande")
public class CommandeController {
	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ClientService clientService;

	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("commandes", commandeService.all());
		return "commande/list";
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goForm(new Commande(), model);
	}

	private String goForm(Commande commande, Model model) {
		model.addAttribute("commande", commande);
		model.addAttribute("clients", clientService.allClient());
		return "commande/create";
	}

	@GetMapping("/delete")
	public String delete() {
		return null;
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("commande") Commande commande, BindingResult br, Model model) {
		if (br.hasErrors()) {
			System.out.println(br);
			return goForm(commande, model);
		}
		commandeService.create(commande);
		return "redirect:/commande";
	}
}
