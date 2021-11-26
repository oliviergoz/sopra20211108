package demoMvc.controller.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import demoMvc.model.AutreClass;
import demoMvc.model.Demo;

@RestController
@RequestMapping("/api/")
public class DemoRestController {

	@GetMapping("/hello")
	public String sayHello() {
		return "hello";
	}

	@GetMapping("/demo")
	public Demo getDemo() {
		return new Demo("olivier", new AutreClass("valuer dans l'autre class"));
	}

	@PostMapping("/demo")
	public Demo createDemo(@RequestParam("nom") String nom) {
		return new Demo(nom);
	}
}
