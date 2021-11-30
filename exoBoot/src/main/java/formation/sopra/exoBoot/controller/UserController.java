package formation.sopra.exoBoot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secure/user")
public class UserController {

	@GetMapping("/home")
	public String home() {
		return "user/home";
	}
}
