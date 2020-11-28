package pe.edu.upc.donacion.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
		try {
			Cita cita = new Cita();
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
	
	@PostMapping("save") // generar-cita/save
	public String save(@ModelAttribute("cita") Cita cita, SessionStatus status) {
		Authentication auth = SecurityContextHolder
	            .getContext()
	            .getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    String userName = userDetail.getUsername();
	    
		try {
			Optional<Donante>optionalDonante= donanteService.findByEmail(userName);
	    	System.out.println(optionalDonante.get().getNombresApellidos());
			Optional<Hospital>optional = hospitalService.findById(cita.getHospital().getId());
			if (optional.isPresent()) {
				if (optional.get().getHorarioApertura().before(cita.getHora()) &&  optional.get().getHorarioCierre().after(cita.getHora())) {
					cita.setEstadoCita("ESPERA");
					cita.setDonante(optionalDonante.get());
					citaService.save(cita);
					status.setComplete();	
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "redirect:/generar-cita";	
	}

// CREAR FUNCIÓN QUE ENVÍE MENSAJE DE CONFIRMACIÓN 
}
