package demoMvc.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import exoJpa.entity.Produit;
import exoJpa.services.ProduitService;

@Controller
@RequestMapping("/panier")
public class PanierController {

	@Autowired
	private ProduitService produitService;

	@GetMapping("")
	public String afficher(Model model) {
		model.addAttribute("produits", produitService.all());
		return "panier/produits";
	}

	@GetMapping("/add")
	public String ajouterProduitAuPanier(@RequestParam("id") Long id, HttpSession session) {
		Produit produit = produitService.byId(id);
		Map<Produit, Integer> panier = getPanier(session);
		panier.put(produit, panier.getOrDefault(produit, 0) + 1);
		return "redirect:/panier";
	}

	private Map<Produit, Integer> getPanier(HttpSession session) {
		if (session.getAttribute("panier") == null) {
			session.setAttribute("panier", new HashMap<Produit, Integer>());
		}
		return (Map<Produit, Integer>) session.getAttribute("panier");

	}

	@GetMapping("/remove")
	public String supprimerProduitDuPanier(@ModelAttribute Produit produit, HttpSession session) {
		Map<Produit, Integer> panier = getPanier(session);
		if (panier.get(produit) == 1) {
			panier.remove(produit);
		} else {
			panier.put(produit, panier.get(produit) - 1);
		}
		return "redirect:/panier";

	}
}
