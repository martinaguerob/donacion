package pe.edu.upc.donacion.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.donacion.models.entities.Donante;
import pe.edu.upc.donacion.models.entities.Usuario;
import pe.edu.upc.donacion.models.repositories.AuthorityRepository;
import pe.edu.upc.donacion.models.repositories.DonanteRepository;
import pe.edu.upc.donacion.models.repositories.UsuarioRepository;
import pe.edu.upc.utils.Segmento;

@Service
public class AddUserDB implements CommandLineRunner{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Autowired
	private DonanteRepository donanteRepository;
	
	@Override
	public void run (String... args) throws Exception {
		// SOLO DESBLOQUEAR CUANDO SE REQUIERA CREAR USUARIO DE FORMA MANUAL
		
		// Creando el objeto que cifra las contraseñas
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String password = bcpe.encode("donante");
		
		BCryptPasswordEncoder bcpeAdmin = new BCryptPasswordEncoder();
		String passwordAdmin = bcpeAdmin.encode("admin");
		
		/*
		Usuario Udonante1 = new Usuario();
		Udonante1.setNombresApellidos("Martin Aguero");
		Udonante1.setEmail("maguerob@upc.edu.pe");
		Udonante1.setPassword( password );
		Udonante1.setSegmento(Segmento.DONANTE);
		Udonante1.setEnable(true);
		
		Donante donante1 = new Donante();
		donante1.setNombresApellidos("Martin Aguero");
		donante1.setEmail("maguerob@upc.edu.pe");
		donante1.setNumeroDocumento("70882998");
		
		Usuario Udonante2 = new Usuario();
		Udonante2.setNombresApellidos("Sammir Fierro");
		Udonante2.setEmail("sfierro@upc.edu.pe");
		Udonante2.setPassword( password );
		Udonante2.setSegmento(Segmento.DONANTE);
		Udonante2.setEnable(true);
		
		Donante donante2 = new Donante();
		donante2.setNombresApellidos("Sammir Fierro");
		donante2.setEmail("sfierro@upc.edu.pe");
		donante2.setNumeroDocumento("71353654");
		
		Usuario admin1 = new Usuario();
		admin1.setNombresApellidos("Daniela Razuri");
		admin1.setEmail("drazuri@upc.edu.pe");
		admin1.setPassword( passwordAdmin );
		admin1.setSegmento(Segmento.ADMINISTRADOR);
		admin1.setEnable(true);
		
		Usuario admin2 = new Usuario();
		admin2.setNombresApellidos("Gabriel Chapiama");
		admin2.setEmail("gchapiama@upc.edu.pe");
		admin2.setPassword( passwordAdmin );
		admin2.setSegmento(Segmento.ADMINISTRADOR);
		admin2.setEnable(true);	
		
		
		Udonante1.addAuthority("ROLE_DONANTE");
		Udonante2.addAuthority("ROLE_DONANTE");
		admin1.addAuthority("ROLE_ADMINISTRADOR");
		admin2.addAuthority("ROLE_ADMINISTRADOR");
		
		
		usuarioRepository.save(Udonante1);
		usuarioRepository.save(Udonante2);
		usuarioRepository.save(admin1);
		usuarioRepository.save(admin2);
		
		donanteRepository.save(donante1);
		donanteRepository.save(donante2);
		*/
	}
}
