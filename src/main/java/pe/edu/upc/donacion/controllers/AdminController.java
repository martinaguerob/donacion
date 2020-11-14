package pe.edu.upc.donacion.controllers;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;

import pe.edu.upc.donacion.models.entities.Caso;
import pe.edu.upc.donacion.models.entities.Distrito;
import pe.edu.upc.donacion.models.entities.Hospital;
import pe.edu.upc.donacion.models.entities.TipoSangre;
import pe.edu.upc.donacion.services.CasoService;
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
	
	@Autowired
	private CasoService casoService;

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
		Distrito distrito = new Distrito();
		try {
			model.addAttribute("distrito", distrito);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/distrito/crear";
	}

	@PostMapping("distrito/save")
	public String saveDistrito(@ModelAttribute("distrito") Distrito distrito, SessionStatus status) {
		try {
			distritoService.save(distrito);
			status.setComplete();

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/admin/distrito";
	}
	
	@GetMapping("distrito/edit/{id}")
	public String editarDistrito(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Distrito> optional = distritoService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("distrito", optional.get());
			}else {
				return "redirect:/admin/distrito";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/distrito/edit";
	}
	
	@PostMapping("distrito/update/{id}")
	public String updateDistrito(@PathVariable("id") Integer id, @ModelAttribute("distrito") Distrito distrito, SessionStatus status) {
		try {
			distritoService.save(distrito);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/admin/distrito";
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
		Hospital hospital = new Hospital();
		try {
			List<Distrito> distritos = distritoService.findAll();
			model.addAttribute("distritos", distritos);
			model.addAttribute("hospital", hospital);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/hospital/crear";
	}

	@PostMapping("hospital/save")
	public String saveHospital(@ModelAttribute("hospital") Hospital hospital, SessionStatus status) {
		try {
			hospitalService.save(hospital);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/admin/hospital";
	}
	
	@GetMapping("hospital/edit/{id}")
	public String editarHospital(@PathVariable("id") Integer id, Model model) {
		try {
			List<Distrito> distritos = distritoService.findAll();
			Optional<Hospital> optional = hospitalService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("distritos", distritos);
				model.addAttribute("hospital", optional.get());
			}else {
				return "redirect:/admin/hospital";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/hospital/edit";
	}
	
	@PostMapping("hospital/update/{id}")
	public String updateHospital(@PathVariable("id") Integer id, @ModelAttribute("hospital") Hospital hospital, SessionStatus status) {
		try {
			hospitalService.save(hospital);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/admin/hospital";
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
	public String saveTipoSangre(@ModelAttribute("tipoSangre") TipoSangre tipoSangre, SessionStatus status) {
		try {
			tipoSangreService.save(tipoSangre);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/admin/tipo-de-sangre";
	}
	
	@GetMapping("tipo-de-sangre/edit/{id}")
	public String editarTipoSangre(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<TipoSangre> optional = tipoSangreService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("tipoSangre", optional.get());
			}else {
				return "redirect:/admin/tipo-de-sangre";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/tiposangre/edit";
	}
	
	@PostMapping("tipo-de-sangre/update/{id}")
	public String updateTipoSangre(@PathVariable("id") Integer id, @ModelAttribute("tipoSangre") TipoSangre tipoSangre, SessionStatus status) {
		try {
			tipoSangreService.save(tipoSangre);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "redirect:/admin/tipo-de-sangre";
	}
	
	
	@GetMapping("caso")
	public String caso(Model model) {
		try {
			List<Caso> casos = casoService.findAll();
			model.addAttribute("casos", casos);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/caso/inicio";
	}

	@GetMapping("caso/crear")
	public String crearCaso(Model model) {
		Caso caso = new Caso();
		try {
			model.addAttribute("caso", caso);
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/caso/crear";
	}

	@PostMapping("caso/save")
	public String saveCaso(@ModelAttribute("caso") Caso caso,
			@RequestParam(name = "file", required = false) MultipartFile foto) {
		if (!foto.isEmpty()) {
			String ruta = "src/main/resources/static/images/casos";

			try {
				byte[] bytes = foto.getBytes();
				Path rutaAbsoulta = Paths.get(ruta + "//" + foto.getOriginalFilename());
				Files.write(rutaAbsoulta, bytes);
				caso.setUrlImage(foto.getOriginalFilename());
				casoService.save(caso);

			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}
		return "redirect:/admin/caso";
	}
	
	@GetMapping("caso/edit/{id}")
	public String editarCaso(@PathVariable("id") Integer id, Model model) {
		try {
			Optional<Caso> optional = casoService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("caso", optional.get());
			}else {
				return "redirect:/admin/caso";
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return "/administrador/caso/edit";
	}

	@PostMapping("caso/update/{id}")
	public String updateCaso(@PathVariable("id") Integer id, @ModelAttribute("caso") Caso caso,
			@RequestParam(name = "file", required = false) MultipartFile foto) {
		if (!foto.isEmpty()) {
			String ruta = "src/main/resources/static/images/casos";

			try {
				byte[] bytes = foto.getBytes();
				Path rutaAbsoulta = Paths.get(ruta + "//" + foto.getOriginalFilename());
				Files.write(rutaAbsoulta, bytes);
				caso.setUrlImage(foto.getOriginalFilename());
				casoService.save(caso);

			} catch (Exception e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}
		return "redirect:/admin/caso";
	}
}
