package formation.sopra.formationSpringBoot.restcontroller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.formationSpringBoot.entities.Client;
import formation.sopra.formationSpringBoot.entities.JsonViews;
import formation.sopra.formationSpringBoot.entities.Role;
import formation.sopra.formationSpringBoot.entities.User;
import formation.sopra.formationSpringBoot.services.auth.CustomUserDetails;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthRestController {

	@GetMapping("")
	@JsonView(JsonViews.UserWithClient.class)
	public User login(@AuthenticationPrincipal CustomUserDetails cUD){
		return cUD.getUser();
	}
}
