package formation.sopra.exoBoot.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/secure/admin")
@PreAuthorize("hasAnyRole('ADMIN')")
public class AdminController {

	@GetMapping("")
	public String home() {
		return "admin/home";
	}
}
