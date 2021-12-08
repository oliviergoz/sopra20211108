package formation.sopra.formationSpringBoot.restcontroller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/demo")
@CrossOrigin(origins = "*")
public class DemoAsyncValidatorRestController {
	@GetMapping("/{data}")
	public boolean demo(@PathVariable("data") String data) {
		List<String> list=Arrays.asList("toto","tutu","tata");
		return list.contains(data);
	}
}
