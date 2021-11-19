package exoJpa;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import exoJpa.config.AppConfig;
import exoJpa.entity.Produit;
import exoJpa.exceptions.ProduitException;
import exoJpa.services.ProduitService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class ProduitTest {

	@Autowired
	private ProduitService produitService;

	private Produit getProduit() {
		Produit produit = new Produit("nom test", "description produit test");
		return produit;
	}

	private Produit getProduit(String nom, String description) {
		return new Produit(nom, description);
	}

	@Test(expected = ProduitException.class)
	public void testSave() {
		Produit produit = getProduit();
		produitService.save(produit);
		assertNotNull(produitService.byId(produit.getId()));
		produitService.delete(produit);
		produitService.byId(produit.getId());
	}

	@Test
	public void testByIdSuccess() {
		assertNotNull(produitService.byId(1L));
	}

	@Test(expected = ProduitException.class)
	public void testByIdFail() {
		assertNotNull(produitService.byId(9999999L));
	}

	@Test
	public void testAll() {
		assertNotNull(produitService.all());
	}

	@Test
	public void testByNom() {
		assertNotNull(produitService.byNom("te"));
	}

}
