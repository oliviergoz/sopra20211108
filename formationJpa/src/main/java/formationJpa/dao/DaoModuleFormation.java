package formationJpa.dao;

import java.util.List;

import formationJpa.entity.Formateur;
import formationJpa.entity.ModuleFormation;
import formationJpa.entity.ModuleFormationKey;

public interface DaoModuleFormation extends DaoGeneric<ModuleFormation, ModuleFormationKey> {
	List<ModuleFormation> findByFormateur(Formateur formateur);
}
