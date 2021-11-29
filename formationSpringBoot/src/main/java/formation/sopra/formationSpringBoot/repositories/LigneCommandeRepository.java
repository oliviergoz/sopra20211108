package formation.sopra.formationSpringBoot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import formation.sopra.formationSpringBoot.entities.Commande;
import formation.sopra.formationSpringBoot.entities.LigneCommande;
import formation.sopra.formationSpringBoot.entities.LigneCommandePK;
import formation.sopra.formationSpringBoot.entities.Produit;

public interface LigneCommandeRepository extends JpaRepository<LigneCommande, LigneCommandePK> {

	@Modifying
	@Transactional
	@Query("delete from LigneCommande lc where lc.id.commande=:commande")
	void deleteByCommande(@Param("commande") Commande commande);

	@Modifying
	@Transactional
	@Query("delete from LigneCommande lc where lc.id.produit=:produit")
	void deleteByProduit(@Param("produit") Produit produit);

	@Modifying
	@Transactional
	@Query("delete from LigneCommande lc where lc.id.produit=:produit and lc.id.commande=:commande")
	void deleteByCommandeAndProduit(@Param("commande") Commande commande, @Param("produit") Produit produit);
}
