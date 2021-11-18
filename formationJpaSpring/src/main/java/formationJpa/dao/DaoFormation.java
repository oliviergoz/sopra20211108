package formationJpa.dao;

import java.util.List;

import formationJpa.entity.Formateur;
import formationJpa.entity.Formation;

public interface DaoFormation extends DaoGeneric<Formation, Long> {
	List<Formation> findWithModules();

	Formation findByIdWithModules(Long id);

	List<Formation> findByReferent(Formateur formateur);
}
