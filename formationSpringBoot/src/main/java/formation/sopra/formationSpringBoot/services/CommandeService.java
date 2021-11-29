package formation.sopra.formationSpringBoot.services;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import formation.sopra.formationSpringBoot.entities.Client;
import formation.sopra.formationSpringBoot.entities.Commande;
import formation.sopra.formationSpringBoot.entities.Produit;
import formation.sopra.formationSpringBoot.exceptions.CommandeException;
import formation.sopra.formationSpringBoot.repositories.CommandeRepository;
import formation.sopra.formationSpringBoot.repositories.LigneCommandeRepository;

@Service
public class CommandeService {

	@Autowired
	private CommandeRepository commandeRepository;
	@Autowired
	private LigneCommandeRepository ligneCommandeRepository;
	@Autowired
	private Validator validator;

	public Commande create(Commande commande) {
		Set<ConstraintViolation<Commande>> violations = validator.validate(commande);
		if (violations.isEmpty()) {
			commandeRepository.save(commande);
			ligneCommandeRepository.saveAll(commande.getLignesCommandes());
			return commande;
		} else {
			throw new CommandeException();
		}
	}

	public void update(Commande commande, Produit produit) {
		ligneCommandeRepository.deleteByCommandeAndProduit(commande, produit);
	}

	public List<Commande> all() {
		return commandeRepository.findAll();
	}

	public Commande byNumero(Long numero) {
		return commandeRepository.findById(numero).orElseThrow(CommandeException::new);
	}

	public List<Commande> byClient(Client client) {
		return commandeRepository.findByClient(client);
	}

	public void delete(Commande commande) {
		ligneCommandeRepository.deleteByCommande(commande);
		commandeRepository.delete(commande);
	}

	public Commande detail(Commande commande) {
		return detail(commande.getNumero());
	}

	public Commande detail(Long numero) {
		return commandeRepository.findByNumeroWithLigneCommande(numero).orElseThrow(CommandeException::new);
	}
}
