package exoJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import exoJpa.entity.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {

}
