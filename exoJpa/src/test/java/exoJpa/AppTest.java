package exoJpa;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import exoJpa.dao.DaoClient;
import exoJpa.dao.DaoClientJpaImpl;
import exoJpa.dao.DaoCommande;
import exoJpa.dao.DaoCommandeJpaImpl;
import exoJpa.dao.DaoFactory;
import exoJpa.dao.DaoProduit;
import exoJpa.dao.DaoProduitJpaImpl;
import exoJpa.entity.Produit;

public class AppTest {
	public static void main(String[] args) {
		DaoClient daoClient = DaoFactory.getInstance(DaoClientJpaImpl.class);
		DaoCommande daoCommande = DaoFactory.getInstance(DaoCommandeJpaImpl.class);
		DaoProduit daoProduit = DaoFactory.getInstance(DaoProduitJpaImpl.class);

//		Produit p = new Produit("tele", "une tete");
//
//		try (FileInputStream fis = new FileInputStream("/Users/olivier/desktop/tele.jpeg")) {
//			p.setPhoto(fis.readAllBytes());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		daoProduit.insert(p);

		Produit p = daoProduit.findByKey(1L);
		try (FileOutputStream fos = new FileOutputStream("/Users/olivier/desktop/copietele.jpeg")) {
			fos.write(p.getPhoto());
		} catch (Exception e) {
			e.printStackTrace();
		}

//		Client c1 = new Client("xxx", "xxxx");
//		daoClient.insert(c1);
//		//traitement long
//		c1.setPrenom("olivier");
//		c1=daoClient.update(c1);
//		//attente d'une saisie
//		c1.setNom("gozlan");
//		c1=daoClient.update(c1);

//		Client c2 = new Client("nina", "m");

//		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//		Validator validator = factory.getValidator();
//
//		Set<ConstraintViolation<Client>> constraintViolation = validator.validate(c2);
//		if (constraintViolation.isEmpty()) {
//			System.out.println("ok");
//			// daoClient.insert(c1);
//		} else {
//			for (ConstraintViolation<Client> violation : constraintViolation) {
//				System.out.println(violation.getMessage());
//			}
//		}

		// daoClient.insert(c2);

//		Produit tele = new Produit("tele", "une tele");
//		Produit ordinateur = new Produit("ordinateur", "un pc gamer");
//
//		daoProduit.insert(ordinateur);
//		daoProduit.insert(tele);
//
//		Commande commande1 = new Commande(c1);
//		commande1.addProduit(ordinateur, 1);
//		commande1.addProduit(tele, 2);
//		daoCommande.insert(commande1);
//
//		// daoCommande.delete(commande1);
//
//		Commande rechercheCommande = daoCommande.findByKey(1L);
//		System.out.println(rechercheCommande.getNumero() + " " + rechercheCommande.getDate() + " "
//				+ rechercheCommande.getClient().getPrenom());
//		rechercheCommande.getLignesCommandes().forEach(lc->{
//			lc.getQuantite()
//		});
		Context.destroy();
	}
}
