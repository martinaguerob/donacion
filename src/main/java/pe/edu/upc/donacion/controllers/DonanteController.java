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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.donacion.models.entities.Cita;
import pe.edu.upc.donacion.models.entities.Distrito;
import pe.edu.upc.donacion.models.entities.Donante;
import pe.edu.upc.donacion.models.entities.TipoSangre;
import pe.edu.upc.donacion.services.CitaService;
import pe.edu.upc.donacion.services.DistritoService;
import pe.edu.upc.donacion.services.DonanteService;
import pe.edu.upc.donacion.services.TipoSangreService;

@Controller
@RequestMapping("/donante")
public class DonanteController {

	@Autowired
	private DonanteService donanteService;

	@Autowired
	private DistritoService distritoService;

	@Autowired
	private TipoSangreService tipoSangreService;

	@Autowired
	private CitaService citaService;

	private UserDetails userDetails;

	@GetMapping
	public String index(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String userName = userDetail.getUsername();

		try {
			Optional<Donante> optional = donanteService.findByEmail(userName);
			System.out.println(optional.get().getNombresApellidos());
			model.addAttribute("donante", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "/user/inicio";
	}

	@GetMapping("{id}")
	public String datosUsuario(@PathVariable("id") Integer id, Model model) {
		try {
			List<TipoSangre> tipoSangres = tipoSangreService.findAll();
			List<Distrito> distritos = distritoService.findAll();
			Optional<Donante> optional = donanteService.findById(id);
			Donante donante = new Donante();
			donante.setNombresApellidos(optional.get().getNombresApellidos());
			model.addAttribute("tipoSangres", tipoSangres);
			model.addAttribute("distritos", distritos);
			model.addAttribute("donante", donante);
			model.addAttribute("datoDonante", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/user/datos";
	}
	@PostMapping("saveDonante/{id}")
	public String saveDatoUsuario(@PathVariable("id") Integer id, @ModelAttribute("donante") Donante donante, SessionStatus status) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String userName = userDetail.getUsername();
		try {
			Optional<Donante> optional = donanteService.findById(id);
			System.out.println(optional.get().getNombresApellidos());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/{donante/id}";
	}

	@GetMapping("mis-citas/{id}")
    public String showCitas(@PathVariable("id") Integer id, Model model) {
        try {
            Optional<Donante> optional = donanteService.findById(id);
            List<Cita> citas = citaService.findByIdDonante(id);
            System.out.println(citas.get(0).getEstadoCita());
            citas.get(0).getEstadoCita();
            model.addAttribute("donante", optional.get());
            model.addAttribute("citas",citas);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }
        return "/user/cita";
    }
}