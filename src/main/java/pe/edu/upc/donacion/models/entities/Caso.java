package pe.edu.upc.donacion.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "casos")
public class Caso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombres_apellidos", nullable = false)
	private String nombresApellidos;
	
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "edad", length = 2, nullable = false)
	private String edad;
	
	@Column(name = "descripcion", length = 1000, nullable = false)
	private String descripcion;
	
	@Column(name = "posicion", nullable = false)
	private String posicion;
	
	@Column(name = "banner")
	private Boolean banner;
	
	@Column(name = "url_image", length = 100)
	private String urlImage;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPosicion() {
		return posicion;
	}

	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}

	public Boolean getBanner() {
		return banner;
	}

	public void setBanner(Boolean banner) {
		this.banner = banner;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}
}
