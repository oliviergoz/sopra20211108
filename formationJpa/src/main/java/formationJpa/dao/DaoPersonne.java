package formationJpa.dao;

import java.util.List;

import formationJpa.entity.Formateur;
import formationJpa.entity.Personne;
import formationJpa.entity.Stagiaire;

public interface DaoPersonne extends DaoGeneric<Personne, Long> {
	List<Formateur> findAllFormateur();

	List<Stagiaire> findAllStagiaire();
	
	Formateur findFormateurByID(Long key);
}
