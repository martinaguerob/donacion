package pe.edu.upc.donacion.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.donacion.models.entities.Cita;
import pe.edu.upc.donacion.models.entities.FichaMedica;
import pe.edu.upc.donacion.models.entities.UnidadSangre;
import pe.edu.upc.donacion.services.CitaService;
import pe.edu.upc.donacion.services.FichaMedicaService;
import pe.edu.upc.donacion.services.UnidadSangreService;

@Controller
@RequestMapping("/admin")
public class AdminDonanteController {

	@Autowired
	private CitaService citaService;
	
	@Autowired
	private FichaMedicaService fichaMedicaService;
	
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
	
	@GetMapping("cita-{id}")
	public String showCita(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Cita> optional = citaService.findById(id);
			Integer id_ficha = fichaMedicaService.findAllOrderDesc().get(0).getId();
			Optional<FichaMedica>optional2 = fichaMedicaService.findById(id_ficha);
			if (optional.get().getFichaMedica() == null) { // SiNo hay ficha
				FichaMedica fichaMedica = new FichaMedica();
				fichaMedica.setDonante(optional.get().getDonante());
				optional.get().setFichaMedica(optional2.get());
				var statusSend = 0;
				model.addAttribute("fichaMedica", fichaMedica);
				model.addAttribute("statusSend", statusSend);
			}else {
				Optional<FichaMedica> optional3 = fichaMedicaService.findById(optional.get().getFichaMedica().getId());
				model.addAttribute("fichaMedica2", optional3.get());
			}	
			model.addAttribute("cita", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/admindonante/cita/show";
	}
	
	@PostMapping("fichamedica/save-{id}")
	public String SaveFicha(@ModelAttribute("fichaMedica") FichaMedica fichaMedica, @PathVariable("id") Integer id, SessionStatus status) {
		try {
			fichaMedicaService.save(fichaMedica);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/admin/cita-{id}-sendficha";
	}
	
	@GetMapping("cita-{id}-sendficha")
	public String SendFicha(@PathVariable("id") Integer id, Model model) {
		try {
			// Datos de la cita actual
			Optional<Cita> optional = citaService.findById(id);
			System.out.println(fichaMedicaService.findAllOrderDesc().get(0).getId());
			System.out.println(fichaMedicaService.findAllOrderAsc().get(0).getId());
			//Agrego el id de la última ficha
			Integer id_ficha = fichaMedicaService.findAllOrderDesc().get(0).getId();
			System.out.println(id_ficha);
			//Busco la última ficha
			Optional<FichaMedica>optional2 = fichaMedicaService.findById(id_ficha);
			var statusSend = 1;
			model.addAttribute("statusSend", statusSend);
			//SI NO HAY FICHA
			if (optional.get().getFichaMedica() == null) { // SiNo hay ficha
				FichaMedica fichaMedica = new FichaMedica();
				fichaMedica.setDonante(optional.get().getDonante());
				
				//Agrego a la cita los datos de la última fiche
				optional.get().setFichaMedica(optional2.get());
				
				model.addAttribute("fichaMedica", fichaMedica);
				
			}else {
				Optional<FichaMedica> optional3 = fichaMedicaService.findById(optional.get().getFichaMedica().getId());
				model.addAttribute("fichaMedica2", optional3.get());
			}
			model.addAttribute("cita", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/admindonante/cita/show";
	}
	
	@PostMapping("citaficha/update/{id}")
	public String updateCitaFicha(@PathVariable("id") Integer id, @ModelAttribute("cita") Cita cita, SessionStatus status) {
		
		try {
			citaService.save(cita);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/admin/cita-{id}";
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