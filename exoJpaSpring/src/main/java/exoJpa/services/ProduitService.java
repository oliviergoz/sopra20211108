package exoJpa.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exoJpa.entity.Client;
import exoJpa.entity.Produit;
import exoJpa.exceptions.ProduitException;
import exoJpa.repositories.LigneCommandeRepository;
import exoJpa.repositories.ProduitRepository;

@Service
public class ProduitService {

	@Autowired
	private ProduitRepository produitRepository;
	@Autowired
	private Validator validator;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;

	public Produit save(Produit produit) {
		Set<ConstraintViolation<Produit>> violations = validator.validate(produit);
		if (violations.isEmpty()) {
			return produitRepository.save(produit);
		} else {
			throw new ProduitException();
		}

	}

	public void delete(Produit produit) {
		delete(produit.getId());
	}

	public void delete(Long id) {
		ligneCommandeRepository.deleteByProduit(byId(id));
		produitRepository.deleteById(id);
	}
	public void delete(Long id) {
		Produit produit = byId(id);
		ligneCommandeRepository.deleteByProduit(produit);
		produitRepository.delete(produit);
	}

	public Produit byId(Long id) {
		return produitRepository.findById(id).orElseThrow(ProduitException::new);
	}

	public List<Produit> all() {
		return produitRepository.findAll();
	}

	public List<Produit> byNom(String nom) {
		return produitRepository.findByNomContaining(nom);
	}
}
