package formationJdbc.test;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import formationJdbc.dao.DaoFormateur;
import formationJdbc.dao.DaoFormateurFactory;
import formationJdbc.dao.DaoFormation;
import formationJdbc.dao.DaoFormationFactory;
import formationJdbc.dao.DaoModule;
import formationJdbc.dao.DaoModuleFactory;
import formationJdbc.dao.DaoModuleFormation;
import formationJdbc.dao.DaoModuleFormationFactory;
import formationJdbc.model.Formateur;
import formationJdbc.model.Formation;
import formationJdbc.model.Module;
import formationJdbc.model.ModuleFormation;
import formationJdbc.model.ModuleFormationKey;

public class App {
	public static void main(String[] args) {

		DaoFormation daoFormation = DaoFormationFactory.getInstance();

		DaoFormateur daoFormateur = DaoFormateurFactory.getInstance();

		DaoModule daoModule = DaoModuleFactory.getInstance();

		DaoModuleFormation daoModuleFormation = DaoModuleFormationFactory.getInstance();

		daoFormation.findAll().stream().map(f -> f.getReferent()).forEach(formateur -> {
			System.out.println((formateur != null) ? formateur.getId() : null);
		});

		List<Formateur> listFormateurReferent = daoFormation.findAll().stream()
				.map(formation -> formation.getReferent()).distinct().collect(Collectors.toList());

//		Formation formation = new Formation("formation1", LocalDate.of(2021, Month.SEPTEMBER, 1));
//		Formateur formateur = new Formateur("olivier", "gozlan");
//
//		daoFormateur.insert(formateur);
//		formation.setReferent(formateur);
//
//		daoFormation.insert(formation);
//
//		Module java = new Module("java", "du java", 3);
//		daoModule.insert(java);
//		Module uml = new Module("uml", "de l'uml", 1);
//		daoModule.insert(uml);
//
//		ModuleFormation mf = new ModuleFormation(new ModuleFormationKey(uml, formation),
//				LocalDate.of(2021, Month.SEPTEMBER, 1), formateur);
//		daoModuleFormation.insert(mf);
//
//		daoModuleFormation.insert(new ModuleFormation(new ModuleFormationKey(java, formation),
//				LocalDate.of(2021, Month.SEPTEMBER, 2), formateur));

	}
}
