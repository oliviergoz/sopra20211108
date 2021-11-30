package formation.sopra.formationSpringBoot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import formation.sopra.formationSpringBoot.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	@Query("select u from User u left join fetch u.roles where u.login=:login")
	Optional<User> findByLogin(@Param("login") String login);

}
