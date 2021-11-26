package exoJpa.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import exoJpa.entity.Client;
import exoJpa.entity.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

	@Transactional
	@Modifying
	@Query("update Commande c set c.client=null where c.client=:client")
	void removeClientFromCommandeByClient(@Param("client") Client client);

	List<Commande> findByClient(Client client);

	@Transactional
	@Query("select c from Commande c left join fetch c.lignesCommandes where c.numero=:numero")
	Optional<Commande> findByNumeroWithLigneCommande(@Param("numero") Long numero);
}
