package pe.edu.upc.donacion.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import pe.edu.upc.donacion.models.entities.Usuario;
import pe.edu.upc.utils.Segmento;

public class UsuarioDetails implements UserDetails {

	private static final long serialVersionUID = 1L;

	// Inyección de dependencia
	private Usuario usuario;
	public UsuarioDetails(Usuario usuario) {
		super();
		this.usuario = usuario;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		this.usuario.getAuthorities().forEach(authority -> {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(authority.getAuthority());
			grantedAuthorities.add(grantedAuthority);
		});
		return grantedAuthorities;
	}
	
	@Override
	public String getUsername() {
		return this.usuario.getEmail();
	}
	
	@Override
	public String getPassword() {
		return this.usuario.getPassword();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return this.usuario.isEnable();
	}

	// Get para el segmento y id del segmento
	public Segmento getSegmento() {
		return this.usuario.getSegmento();
	}

	
}
