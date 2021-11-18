package exoJpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import exoJpa.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
