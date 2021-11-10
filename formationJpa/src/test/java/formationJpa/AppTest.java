package formationJpa;

import java.time.LocalDate;
import java.time.Month;

import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoFormationFactory;
import formationJpa.dao.DaoModule;
import formationJpa.dao.DaoModuleFactory;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneFactory;
import formationJpa.entity.Adresse;
import formationJpa.entity.Formateur;
import formationJpa.entity.Personne;
import formationJpa.entity.Stagiaire;
import formationJpa.util.Context;

public class AppTest {
	public static void main(String[] args) {
		DaoFormation daoFormation = DaoFormationFactory.getInstance();
		DaoModule daoModule = DaoModuleFactory.getInstance();
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		Formateur p = new Formateur();
		p.setPrenom("olivier");
		p.setNom("gozlan");
		p.setDateNaissance(LocalDate.of(2000, Month.APRIL, 23));
		p.setAdresse(new Adresse(11, "rue xxxx", "75000", "paris"));
		p.setExperience(10);
		daoPersonne.insert(p);

		Stagiaire s = new Stagiaire();
		s.setEntreprise("sopra");
		daoPersonne.insert(s);

//		daoPersonne.findByKey(s.getId());
//		daoPersonne.findAll().forEach(personne -> {
//			System.out.println(personne.getClass().getName());
//		});

		daoPersonne.findAllFormateur();
		daoPersonne.findAllStagiaire();
		Context.destroy();
	}
}
