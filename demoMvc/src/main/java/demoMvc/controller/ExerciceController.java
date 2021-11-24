package demoMvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/exo")
public class ExerciceController {

	// @RequestMapping(path = "/form", method = RequestMethod.GET)
	@GetMapping("/form")
	public String formulaire() {
		return "exo/form";
	}

	// @RequestMapping(path = "/form", method = RequestMethod.POST)
	@PostMapping("/form")
	public String validationFormulaire(@RequestParam(name = "prenom", required = false) String prenom, Model model,HttpSession session) {
		if (prenom == null || prenom.isEmpty()) {
			model.addAttribute("error", true);
			return "exo/form";
		}
		model.addAttribute("prenom", prenom);
		return "exo/hello";
	}
}
