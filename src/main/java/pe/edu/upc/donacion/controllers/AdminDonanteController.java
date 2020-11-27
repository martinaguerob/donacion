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
<<<<<<< HEAD
import pe.edu.upc.donacion.models.entities.Donacion;
import pe.edu.upc.donacion.models.entities.FichaMedica;
import pe.edu.upc.donacion.models.entities.UnidadSangre;
import pe.edu.upc.donacion.services.CitaService;
import pe.edu.upc.donacion.services.DonacionService;
=======
import pe.edu.upc.donacion.models.entities.FichaMedica;
import pe.edu.upc.donacion.models.entities.UnidadSangre;
import pe.edu.upc.donacion.services.CitaService;
>>>>>>> 5021b29f88e65144572d6ec20835cf437d686697
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
	private FichaMedicaService fichaMedicaService;
	
	@Autowired
	private UnidadSangreService unidadSangreService;

	@Autowired
	private DonacionService donacionService;

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
<<<<<<< HEAD

	@GetMapping("cita-{id}")
	public String showCita(@PathVariable("id") Integer id, Model model) {
		try {
			// DATOS DE LA CITA ACTUAL
			Optional<Cita> optional = citaService.findById(id);

			// SI NO HAY FICHA EN LA CITA
			if (optional.get().getFichaMedica() == null) {
				// CREO NUEVA FICHA
				FichaMedica fichaMedica = new FichaMedica();
				// ENVIAR ATRIBUTOS PARA CREAR NUEVA FICHA MÉDICA
				model.addAttribute("fichaMedica", fichaMedica);
			} else {
				// MOSTRAR FICHA MEDICA
				Optional<FichaMedica> optionalFicha = fichaMedicaService
						.findById(optional.get().getFichaMedica().getId());
				// ENVIAMOS DATOS DE LAS FICHAS MÉDICAS PARA MOSTRAR
				model.addAttribute("fichaMedica", optionalFicha.get());

				// CREAR UNIDAD DE SANGRE
				UnidadSangre unidadSangre = new UnidadSangre();
				// ENVIAMOS ATRIBUTOS PARA CREAR UNIDAD DE SANGRE
				model.addAttribute("unidadSangre", unidadSangre);

				if (optional.get().getEstadoCita().equals("DONÓ")) {
					Optional<UnidadSangre> optionalUnidad = unidadSangreService
							.findById(optionalFicha.get().getUnidadSangre().getId());
					model.addAttribute("unidadDeSangre", optionalUnidad.get());
					
					Optional<Donacion> optionalDonacion = donacionService.findById(optionalUnidad.get().getId());
					model.addAttribute("donacion", optionalDonacion.get());
				}
=======
	
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
>>>>>>> 5021b29f88e65144572d6ec20835cf437d686697
			}
			model.addAttribute("cita", optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		
		return "/admindonante/cita/show";
	}
<<<<<<< HEAD

	@PostMapping("fichamedica/save-{id}")
	public String SaveFicha(@ModelAttribute("fichaMedica") FichaMedica fichaMedica, @PathVariable("id") Integer id,
			SessionStatus status) {
=======
	
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
>>>>>>> 5021b29f88e65144572d6ec20835cf437d686697
		try {
			Optional<Cita> optional = citaService.findById(id);
			fichaMedica.setDonante(optional.get().getDonante());
			fichaMedicaService.save(fichaMedica);
			status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return saveFichaCita(id);
	}

	public String saveFichaCita(@PathVariable("id") Integer id) {
		try {
			// DATOS DE LA CITA MÉDICA
			Optional<Cita> optional = citaService.findById(id);
			// ID DE LA ÚLTIMA FICHA MÉDICA
			Integer id_ficha = fichaMedicaService.findAllOrderDesc().get(0).getId();
			// TRAIGO LOS DATOS DE LA ÚLTIMA FICHA MÉDICA REGISTRADA
			Optional<FichaMedica> optionalUltFicha = fichaMedicaService.findById(id_ficha);
			// AGREGO FICHA MEDICA
			optional.get().setFichaMedica(optionalUltFicha.get());
			// ACTUALIZO ESTADO DE LA CITA
			optional.get().setEstadoCita("ATENDIÓ");
			// ACTUALIZO Y GUARDO
			citaService.save(optional.get());
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/admin/cita-{id}";
	}
<<<<<<< HEAD

	// SALVAR UNIDAD DE SANGRE (RECIBE ID CITA)
	@PostMapping("unidadSangre/save-{id}")
	public String saveUnidad(@PathVariable("id") Integer id, @ModelAttribute("unidadSangre") UnidadSangre unidadSangre,
			SessionStatus status) {
		try {
			 unidadSangreService.save(unidadSangre);
			 status.setComplete();
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return saveDonacion(id);
	}

	public String saveDonacion(@PathVariable("id") Integer id) {
		try {

			// DATOS DE LA CITA EN LA QUE ESTOY
			Optional<Cita> optional = citaService.findById(id);
			// ID DE LA ÚLTIMA UNIDAD DE SANGRE
			Integer id_unidad = unidadSangreService.findAllOrderByIdDesc().get(0).getId();
			// TRAIGO LOS DATOS DE LA ÚLTIMA UNIDAD DE SANGRE REGISTRADA
			Optional<UnidadSangre> optionalUltUnidad = unidadSangreService.findById(id_unidad);
			System.out.println(optional.get().getEstadoCita());

			
			// CREAR DONACION
			Donacion donacion = new Donacion();
			// LE AGREGO DONANTE
			donacion.setDonante(optional.get().getDonante());
			// LE AGREGO UNIDAD SANGRE
			donacion.setUnidadSangre(optionalUltUnidad.get());
			// LE AGREGO LA FECHA
			donacion.setFechaDonacion(optional.get().getFechaCita());
			// GUARDAR DONACION
			 donacionService.save(donacion);

			// GUARDAR UNIDAD EN FICHA
			// TRAER LA FICHA MÉDICA
			Optional<FichaMedica> optionalFicha = fichaMedicaService.findById(optional.get().getFichaMedica().getId());
			// GUARDO ID UNIDAD EN FICHA
			optionalFicha.get().setUnidadSangre(optionalUltUnidad.get());
			// GUARDO FICHA MEDICA
			fichaMedicaService.save(optionalFicha.get());

			// GUARDAR ESTADO
			optional.get().setEstadoCita("DONÓ");
			citaService.save(optional.get());

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}

		return "redirect:/admin/cita-{id}";
	}

=======
>>>>>>> 5021b29f88e65144572d6ec20835cf437d686697
}