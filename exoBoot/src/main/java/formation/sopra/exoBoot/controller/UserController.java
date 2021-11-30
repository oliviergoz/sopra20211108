package formation.sopra.exoBoot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secure/user")
@PreAuthorize("hasAnyRole('USER')")
public class UserController {

	@GetMapping("")
	public String home() {
		return "user/home";
	}
}
