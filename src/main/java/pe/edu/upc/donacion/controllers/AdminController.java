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

import pe.edu.upc.donacion.models.entities.Distrito;
import pe.edu.upc.donacion.models.entities.Hospital;
import pe.edu.upc.donacion.models.entities.TipoSangre;
import pe.edu.upc.donacion.services.DistritoService;
import pe.edu.upc.donacion.services.HospitalService;
import pe.edu.upc.donacion.services.TipoSangreService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private DistritoService distritoService;

	@Autowired
	private HospitalService hospitalService;

	@Autowired
	private TipoSangreService tipoSangreService;

	@GetMapping
	public String index(Model model) {
		return "/administrador/inicio";
	}

	@GetMapping("distrito")
	public String distrito(Model model) {
		try {
			List<Distrito> distritos = distritoService.findAll();
			model.addAttribute("distritos", distritos);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/distrito/inicio";
	}

	@GetMapping("distrito/crear")
	public String crearDistrito(Model model) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/distrito/crear";
	}

	@GetMapping("hospital")
	public String hospital(Model model) {
		try {
			List<Hospital> hospitales = hospitalService.findAll();
			model.addAttribute("hospitales", hospitales);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/hospital/inicio";
	}

	@GetMapping("hospital/crear")
	public String crearHospital(Model model) {
		try {

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/hospital/crear";
	}

	@GetMapping("tipo-de-sangre")
	public String tipoSangre(Model model) {
		try {
			List<TipoSangre> tiposSangres = tipoSangreService.findAll();
			model.addAttribute("tiposSangres", tiposSangres);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/tiposangre/inicio";
	}

	@GetMapping("tipo-de-sangre/crear")
	public String crearTipoSangre(Model model) {
		TipoSangre tipoSangre = new TipoSangre();
		try {
			model.addAttribute("tipoSangre", tipoSangre);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/tiposangre/crear";
	}

	@PostMapping("tipo-de-sangre/save")
	public String saveTipoSangrel(@ModelAttribute("tipoSangre") TipoSangre tipoSangre, SessionStatus status) {
		try {
			tipoSangreService.save(tipoSangre);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/admin/tipo-de-sangre";
	}
}
