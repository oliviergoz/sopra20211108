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
import org.springframework.web.bind.annotation.RequestParam;

import formation.sopra.formationSpringBoot.entities.Produit;
import formation.sopra.formationSpringBoot.services.ProduitService;

//CRUD produit
@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitService;

	// liste
	@GetMapping("")
	public String list(Model model) {
		model.addAttribute("produits", produitService.all());
		return "produit/list";
	}

	// editer
	@GetMapping("/edit")
	public String edit(@RequestParam(name = "id") Long id, Model model) {
		return goEdit(produitService.byId(id), model);
	}

	// ajouter
	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Produit(), model);
	}

	private String goEdit(Produit produit, Model model) {
		model.addAttribute("produit", produit);
		return "produit/editSpring";
	}

	// supprimer
	@GetMapping("/delete")
	public String delete(@RequestParam(name = "id", required = true) Long id) {
		produitService.delete(id);
		return "redirect:/produit";
	}

	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("produit") Produit produit, BindingResult br, Model model) {
		if (br.hasErrors()) {
			System.out.println(br);
			return goEdit(produit, model);
		}
		produitService.save(produit);
		return "redirect:/produit";
	}
}
