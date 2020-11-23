package pe.edu.upc.donacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.donacion.models.entities.Cita;
import pe.edu.upc.donacion.models.entities.UnidadSangre;
import pe.edu.upc.donacion.services.CitaService;
import pe.edu.upc.donacion.services.UnidadSangreService;

@Controller
@RequestMapping("/admin")
public class AdminDonanteController {

	@Autowired
	private CitaService citaService;
	
	@Autowired
	private UnidadSangreService unidadSangreService;

	@GetMapping("cita")
	public String index(Model model) {
		try {
			List<Cita> citas = citaService.findAll();
			model.addAttribute("citas", citas);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/admindonante/cita/inicio";
	}
	
	@GetMapping("cita/id")
	public String showCita(Model model) {
		try {
			List<Cita> citas = citaService.findAll();
			model.addAttribute("citas", citas);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/admindonante/cita/show";
	}
	
	@GetMapping("unidades-de-sangre")
	public String unidadSangre(Model model) {
		try {
			List<UnidadSangre> unidadesSangre = unidadSangreService.findAll();
			model.addAttribute("unidadesSangre", unidadesSangre);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/admindonante/unidadsangre/inicio";
	}
	
	@GetMapping("unidades-de-sangre/crear")
	public String unidadSangreCrear(Model model) {
		try {
			List<UnidadSangre> unidadesSangre = unidadSangreService.findAll();
			model.addAttribute("unidadesSangre", unidadesSangre);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/admindonante/unidadsangre/crear";
	}
	
}
