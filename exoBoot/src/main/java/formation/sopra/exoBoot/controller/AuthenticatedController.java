package formation.sopra.exoBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secure")
public class AuthenticatedController {

	@GetMapping("")
	public String homeAuthenticated() {
		return "auth/home";
	}

}
