package exoJpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import exoJpa.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

	List<Client> findByPrenom(String prenom);

	List<Client> findByPrenomLike(String prenom);

	List<Client> findByPrenomContaining(String prenom);

	List<Client> findByPrenomContainingOrNomContaining(String prenom, String nom);

	List<Client> findByPrenomContainingIgnoreCase(String prenom);

	List<Client> findByPrenomContainingIgnoreCaseOrNomContainingIgnoreCase(String prenom, String nom);

	@Query("select c from Client c left join fetch c.commandes where c.id=:id")
	Optional<Client> findByIdWithCommandes(@Param("id") Long id);

	// @Query("select c from Client c left join fetch c.commandes")
	List<Client> findAllWithCommandes();

}
