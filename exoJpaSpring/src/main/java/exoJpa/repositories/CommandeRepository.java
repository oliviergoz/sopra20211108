package exoJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import exoJpa.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

}
