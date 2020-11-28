package pe.edu.upc.donacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.donacion.models.entities.Caso;
import pe.edu.upc.donacion.services.CasoService;

@Controller
@RequestMapping("/")
public class IndexController {

	@Autowired
	private CasoService casoService;

	@GetMapping
	public String index(Model model) {
		try {
			List<Caso> casos = casoService.findAll();
			model.addAttribute("casos", casos);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "inicio";
	}

	@GetMapping("help")
	public String help() {
		return "help";
	}
	
	@GetMapping("layout")
	public String layout() {
		return "layout/layout";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
}
