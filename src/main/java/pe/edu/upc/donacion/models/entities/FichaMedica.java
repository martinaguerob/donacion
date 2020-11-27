package pe.edu.upc.donacion.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "fichas_medicas")
public class FichaMedica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "donante_id")
	private Donante donante;
	
	@Column(name = "ets", nullable = false)
	private Boolean ets;
	
	@Column(name = "hemoglobina", nullable = false)
	private Float hemoglobina;
	
	@Column(name = "estado", nullable = false)
	private Boolean estado;
	
	@Column(name = "comentarios", nullable = false)
	private String comentarios;
	
	@OneToOne(mappedBy = "fichaMedica")
	private Cita cita;
	
	@OneToOne
	@JoinColumn(name="unidadSangre_id")
	private UnidadSangre unidadSangre;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Donante getDonante() {
		return donante;
	}

	public void setDonante(Donante donante) {
		this.donante = donante;
	}

	public Boolean getEts() {
		return ets;
	}

	public void setEts(Boolean ets) {
		this.ets = ets;
	}

	public Float getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(Float hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public Boolean getEstado() {
		return estado;
	}

	public void setEstado(Boolean estado) {
		this.estado = estado;
	}
	
	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public Cita getCita() {
		return cita;
	}

	public void setCita(Cita cita) {
		this.cita = cita;
	}

	public UnidadSangre getUnidadSangre() {
		return unidadSangre;
	}

	public void setUnidadSangre(UnidadSangre unidadSangre) {
		this.unidadSangre = unidadSangre;
	}
	
	
}
