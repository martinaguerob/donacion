package pe.edu.upc.donacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.donacion.models.entities.Cita;
import pe.edu.upc.donacion.models.entities.Donante;
import pe.edu.upc.donacion.models.entities.Hospital;
import pe.edu.upc.donacion.services.CitaService;
import pe.edu.upc.donacion.services.DonanteService;
import pe.edu.upc.donacion.services.HospitalService;

@Controller
@RequestMapping("/registro-cita")
public class RegistroCitaController {
	
	@Autowired
	private CitaService citaService;
	
	@Autowired
	private HospitalService hospitalService;
	
	@Autowired
	private DonanteService donanteService;
	
	@GetMapping
	public String index(Model model) {
		try {
			List<Cita> citas = citaService.findAll();
			List<Donante> donantes = donanteService.findAll();
			List<Hospital> hospitales = hospitalService.findAll();
			model.addAttribute("citas", citas);
			model.addAttribute("donantes", donantes);
			model.addAttribute("hospitales", hospitales);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/registro-citas/inicio";
	}
	
	@PostMapping("search")
	public String search(@ModelAttribute("donante") Integer id, Model model) {
		return "registro-citas/show";
	}

}
