package pe.edu.upc.donacion.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pe.edu.upc.donacion.models.entities.Usuario;
import pe.edu.upc.donacion.models.repositories.AuthorityRepository;
import pe.edu.upc.donacion.models.repositories.UsuarioRepository;
import pe.edu.upc.utils.Segmento;

@Service
public class AddUserDB implements CommandLineRunner{
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AuthorityRepository authorityRepository;
	
	@Override
	public void run (String... args) throws Exception {
		// SOLO DESBLOQUEAR CUANDO SE REQUIERA CREAR USUARIO DE FORMA MANUAL
		
		// Creando el objeto que cifra las contraseñas
		BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();
		String password = bcpe.encode("donante");
		
		BCryptPasswordEncoder bcpeAdmin = new BCryptPasswordEncoder();
		String passwordAdmin = bcpeAdmin.encode("admin");
		
		/*
		Usuario donante1 = new Usuario();
		donante1.setNombresApellidos("Martin Aguero");
		donante1.setEmail("maguerob@upc.edu.pe");
		donante1.setPassword( password );
		donante1.setSegmento(Segmento.DONANTE);
		donante1.setEnable(true);
		
		Usuario admin1 = new Usuario();
		admin1.setNombresApellidos("Daniela Razuri");
		admin1.setEmail("drazuri@upc.edu.pe");
		admin1.setPassword( passwordAdmin );
		admin1.setSegmento(Segmento.ADMINISTRADOR);
		admin1.setEnable(true);
		
		
		usuarioRepository.save(donante1);
		usuarioRepository.save(admin1);
		*/
		/*
		Usuario cliente2 = new Usuario();
		cliente2.setUsername("cliente2");
		cliente2.setPassword( password );
		cliente2.setSegmento(Segmento.CLIENTE);
		cliente2.setIdSegmento(2);
		cliente2.setEnable(true);
		
		Usuario cliente3 = new Usuario();
		cliente3.setUsername("cliente3");
		cliente3.setPassword( password );
		cliente3.setSegmento(Segmento.CLIENTE);
		cliente3.setIdSegmento(3);
		cliente3.setEnable(true);
		
		// Creando el objeto que cifra las contraseñas
		BCryptPasswordEncoder bcpeTienda = new BCryptPasswordEncoder();
		String passwordTienda = bcpeTienda.encode("tienda");
		
		Usuario tienda1 = new Usuario();
		tienda1.setUsername("tienda4");
		tienda1.setPassword(passwordTienda);
		tienda1.setSegmento(Segmento.TIENDA);
		tienda1.setIdSegmento(4);
		tienda1.setEnable(true);
		
		Usuario tienda2 = new Usuario();
		tienda2.setUsername("tienda5");
		tienda2.setPassword(passwordTienda);
		tienda2.setSegmento(Segmento.TIENDA);
		tienda2.setIdSegmento(5);
		tienda2.setEnable(true);
		
		Usuario tienda3 = new Usuario();
		tienda3.setUsername("tienda6");
		tienda3.setPassword(passwordTienda);
		tienda3.setSegmento(Segmento.TIENDA);
		tienda3.setIdSegmento(6);
		tienda3.setEnable(true);
		
		// Roles de usuario: ROLE_CLIENTE, ROLE_TIENDA, ROLE_DELIVERY, ROLE_ADMIN, ROLE_
		cliente1.addAuthority("ROLE_CUSTOMER");
		cliente2.addAuthority("ROLE_CUSTOMER");
		cliente3.addAuthority("ROLE_CUSTOMER");
		tienda1.addAuthority("ROLE_STORE");
		tienda2.addAuthority("ROLE_STORE");
		tienda3.addAuthority("ROLE_STORE");
		
		// Accesos a recursos
		cliente1.addAuthority("ACCESS_PROMO");
		cliente3.addAuthority("ACCESS_PROMO");
		cliente1.addAuthority("ACCESS_DESC");
		tienda3.addAuthority("ACCESS_FREE");
		
		usuarioRepository.save(cliente1);
		usuarioRepository.save(cliente2);
		usuarioRepository.save(cliente3);
		
		usuarioRepository.save(tienda1);
		usuarioRepository.save(tienda2);
		usuarioRepository.save(tienda3);*/
		
	}
}
