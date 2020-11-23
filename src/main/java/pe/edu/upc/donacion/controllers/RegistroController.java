package pe.edu.upc.donacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.donacion.models.entities.Distrito;
import pe.edu.upc.donacion.models.entities.TipoSangre;
import pe.edu.upc.donacion.services.DistritoService;
import pe.edu.upc.donacion.services.TipoSangreService;

@Controller
@RequestMapping("/registro")
public class RegistroController {

	@Autowired
	private DistritoService distritoService;
	
	@Autowired
	private TipoSangreService tipoSangreService;
	
	@GetMapping
	public String index(Model model) {
		try {
			List<Distrito> distritos = distritoService.findAll();
			List<TipoSangre> tipoSangres = tipoSangreService.findAll();
			model.addAttribute("distritos", distritos);
			model.addAttribute("tipoSangres", tipoSangres);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/registro/inicio";
	}
}
