package pe.edu.upc.donacion.models.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "distritos")
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "nombre", length = 25, nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy = "distrito")
	private List<Hospital> hospitales;
	
	@OneToMany(mappedBy = "distrito")
	private List<Donante> donantes;
	
	public Distrito() {
		hospitales = new ArrayList<Hospital>();
		donantes = new ArrayList<Donante>();
	}
	
	public String getIdString() {
		return Integer.toString(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Hospital> getHospitales() {
		return hospitales;
	}

	public void setHospitales(List<Hospital> hospitales) {
		this.hospitales = hospitales;
	}

	public List<Donante> getDonantes() {
		return donantes;
	}

	public void setDonantes(List<Donante> donantes) {
		this.donantes = donantes;
	}

}
