package pe.edu.upc.donacion.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/donante")
public class DonanteController {

	@GetMapping
	public String index(Model model) {
	return "/user/inicio";
	}
}
