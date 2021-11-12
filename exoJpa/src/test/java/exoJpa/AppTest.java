package exoJpa;

import exoJpa.dao.DaoClient;
import exoJpa.dao.DaoClientJpaImpl;
import exoJpa.dao.DaoCommande;
import exoJpa.dao.DaoCommandeJpaImpl;
import exoJpa.dao.DaoFactory;
import exoJpa.dao.DaoProduit;
import exoJpa.dao.DaoProduitJpaImpl;
import exoJpa.entity.Client;
import exoJpa.entity.Commande;
import exoJpa.entity.Produit;

public class AppTest {
	public static void main(String[] args) {
		DaoClient daoClient = DaoFactory.getInstance(DaoClientJpaImpl.class);
		DaoCommande daoCommande = DaoFactory.getInstance(DaoCommandeJpaImpl.class);
		DaoProduit daoProduit = DaoFactory.getInstance(DaoProduitJpaImpl.class);

		Client c1 = new Client("olivier", "gozlan");
		Client c2 = new Client("nina", "m");

		daoClient.insert(c1);
		daoClient.insert(c2);

		Produit tele = new Produit("tele", "une tele");
		Produit ordinateur = new Produit("ordinateur", "un pc gamer");

		daoProduit.insert(ordinateur);
		daoProduit.insert(tele);

		Commande commande1 = new Commande(c1);
		commande1.addProduit(ordinateur, 1);
		commande1.addProduit(tele, 2);
		daoCommande.insert(commande1);

		daoCommande.delete(commande1);

		Context.destroy();
	}
}
