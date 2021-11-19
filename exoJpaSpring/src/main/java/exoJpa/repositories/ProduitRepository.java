package exoJpa.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import exoJpa.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
	@Transactional
	List<Produit> findByNomContaining(String nom);
}
