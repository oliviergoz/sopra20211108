package formationJpa;

import java.time.LocalDate;
import java.time.Month;

import formationJpa.dao.DaoFormation;
import formationJpa.dao.DaoFormationFactory;
import formationJpa.dao.DaoModule;
import formationJpa.dao.DaoModuleFactory;
import formationJpa.dao.DaoOrdinateur;
import formationJpa.dao.DaoOrdinateurFactory;
import formationJpa.dao.DaoPersonne;
import formationJpa.dao.DaoPersonneFactory;
import formationJpa.entity.Adresse;
import formationJpa.entity.Civilite;
import formationJpa.entity.Disque;
import formationJpa.entity.Formateur;
import formationJpa.entity.Formation;
import formationJpa.entity.Ordinateur;
import formationJpa.entity.Personne;
import formationJpa.entity.Ram;
import formationJpa.entity.Stagiaire;
import formationJpa.util.Context;

public class AppTest {
	public static void main(String[] args) {
		DaoFormation daoFormation = DaoFormationFactory.getInstance();
		DaoModule daoModule = DaoModuleFactory.getInstance();
		DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();
		DaoOrdinateur daoOrdinateur = DaoOrdinateurFactory.getInstance();

		Formateur f = new Formateur();
		f.setPrenom("olivier");
		daoPersonne.insert(f);

		Formation formation = new Formation();
		formation.setNom("java");
		formation.setReferent(f);
		daoFormation.insert(formation);

		// daoFormation.findByKey(formation.getId());
		System.out.println("--------------------------");
		System.out.println(daoPersonne.findFormateurByID(f.getId()));

//		Stagiaire s = new Stagiaire();
//		s.setPrenom("quentin");
//		s.setCivilite(Civilite.M);
//		daoPersonne.insert(s);
//
//		System.out.println("--------------------------");
//		Ordinateur pc = new Ordinateur();
//		pc.setDisque(Disque.SSD500Go);
//		pc.setRam(Ram.RAM16);
//		daoOrdinateur.insert(pc);
//		
//
//		System.out.println("--------------------------");
//
//		s.setPc(pc);
//		System.out.println("--------------------------");
//		daoPersonne.update(s);
//		System.out.println("--------------------------");
//		
//		System.out.println(daoOrdinateur.findByKey(pc.getId()).getStagiaire());

		Context.destroy();
	}
}
