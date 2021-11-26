package demoMvc.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import exoJpa.entity.Commande;
import exoJpa.entity.JsonViews;
import exoJpa.services.CommandeService;

@RestController
@RequestMapping("/api/commande")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeService;

	@GetMapping("")
	@JsonView(JsonViews.CommandeAvecClient.class)
	public List<Commande> all() {
		return commandeService.all();
	}

	@GetMapping("/{numero}")
	@JsonView(JsonViews.CommandeAvecLigneCommande.class)
	public Commande byNumero(@PathVariable("numero") Long numero) {
		return commandeService.detail(numero);
	}

	@PostMapping("")
	@JsonView(JsonViews.CommandeAvecLigneCommande.class)
	public Commande create(@Valid @RequestBody Commande commande, BindingResult br) {
		commande.getLignesCommandes().forEach(lc -> {
			lc.getId().setCommande(commande);
		});
		return commandeService.create(commande);
	}
}
