package formationJdbc.dao;

import java.util.List;

import formationJdbc.model.Formateur;
import formationJdbc.model.Formation;

public interface DaoFormation extends DaoGeneric<Formation, Integer> {
	// List<Formation> findByDate(LocalDate date);
	List<Formation> findByReferent(Formateur formateur);
}
