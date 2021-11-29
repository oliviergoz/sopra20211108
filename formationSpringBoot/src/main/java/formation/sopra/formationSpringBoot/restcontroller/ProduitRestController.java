package formation.sopra.formationSpringBoot.restcontroller;

import java.util.List;

import javax.validation.Valid;

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

import formation.sopra.formationSpringBoot.entities.JsonViews;
import formation.sopra.formationSpringBoot.entities.Produit;
import formation.sopra.formationSpringBoot.services.ProduitService;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {

	@Autowired
	private ProduitService produitService;

	@GetMapping("")
	@JsonView(JsonViews.Common.class)
	public List<Produit> all() {
		return produitService.all();
	}

//	@GetMapping("/avecLigne")
//	@JsonView(JsonViews.ProduitAvecLigneCommande.class)
//	public List<Produit> allAvecLigneCommande() {
//		return produitService.all();
//	}

	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Produit byId(@PathVariable("id") Long id) {
		return produitService.byId(id);
	}

	@PostMapping("")
	@ResponseStatus(code = HttpStatus.CREATED)
	@JsonView(JsonViews.Common.class)
	public Produit create(@Valid @RequestBody Produit produit, BindingResult br) {
		produitService.save(produit);
		return produit;
	}

	@PutMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public Produit update(@PathVariable("id") Long id, @Valid @RequestBody Produit produit, BindingResult br) {
		produit.setId(id);
		produitService.save(produit);
		return produit;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		produitService.delete(id);
	}

}
