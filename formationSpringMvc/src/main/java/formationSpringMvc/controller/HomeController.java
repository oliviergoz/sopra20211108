package formationSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping({ "", "/home" })
	public String home(Model model, @RequestParam(name = "user", required = false, defaultValue = "world") String user,
			@RequestParam(name = "age", required = false, defaultValue = "0") int age) {
		System.out.println(age);
		model.addAttribute("user", user);
		return "home";
	}

	@RequestMapping("/page")
	public String page() {
		return "page";
	}

}
