package pe.edu.upc.donacion.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.donacion.models.entities.Cita;
import pe.edu.upc.donacion.models.entities.Donante;
import pe.edu.upc.donacion.models.entities.Hospital;
import pe.edu.upc.donacion.services.CitaService;
import pe.edu.upc.donacion.services.DonanteService;
import pe.edu.upc.donacion.services.HospitalService;

@Controller
@RequestMapping("/generar-cita")
public class GenerarCitaController {
	
	@Autowired
	private CitaService citaService;
	
	@Autowired
	private DonanteService donanteService;
	
	@Autowired
	private HospitalService hospitalService;
	
	@GetMapping
	public String index(Model model) {
		Cita cita = new Cita();
		try {
			List<Donante> donantes = donanteService.findAll();
			List<Hospital> hospitales = hospitalService.findAll();
			model.addAttribute("donantes", donantes);
			model.addAttribute("hospitales", hospitales);
			model.addAttribute("cita", cita);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/generar-cita/inicio";
	}
	
	@PostMapping("save")
	public String save(@ModelAttribute("cita") Cita cita, SessionStatus status) {
		try {
			citaService.save(cita);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/generar-cita";
	}
}
