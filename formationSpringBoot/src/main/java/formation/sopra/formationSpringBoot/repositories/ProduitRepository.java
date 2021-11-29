package formation.sopra.formationSpringBoot.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import formation.sopra.formationSpringBoot.entities.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	@Transactional
	List<Produit> findByNomContaining(String nom);
}
