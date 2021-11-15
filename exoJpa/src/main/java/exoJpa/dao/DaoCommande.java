package exoJpa.dao;

import java.util.List;

import exoJpa.entity.Commande;

public interface DaoCommande extends DaoGeneric<Commande, Long> {
	Commande findByKeyWithLignesCommandes(Long key);

	List<Commande> findAllWithLignesCommandes();
}
