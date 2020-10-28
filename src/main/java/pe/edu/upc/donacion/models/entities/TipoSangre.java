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
@Table(name = "tipo_sangres")
public class TipoSangre {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "nombre", length = 30, nullable = false)
	private String nombre;

	@OneToMany(mappedBy = "tipoSangre")
	private List<Donante> donantes;

	public TipoSangre() {
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

	public List<Donante> getDonantes() {
		return donantes;
	}

	public void setDonantes(List<Donante> donantes) {
		this.donantes = donantes;
	}

}
