package pe.edu.upc.donacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.donacion.models.entities.Donante;
import pe.edu.upc.donacion.models.entities.Hospital;
import pe.edu.upc.donacion.services.DonanteService;
import pe.edu.upc.donacion.services.HospitalService;

@Controller
@RequestMapping("/generar-cita")
public class GenerarCitaController {
	@Autowired
	private DonanteService donanteService;
	
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping
	public String index(Model model) {
		try {
			List<Donante> donantes = donanteService.findAll();
			List<Hospital> hospitales = hospitalService.findAll();
			model.addAttribute("donantes", donantes);
			model.addAttribute("hospitales", hospitales);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/generar-cita/inicio";
	}
}
