package pe.edu.upc.donacion.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "citas")
public class Cita {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "donante_id")
	private Donante donante;

	@ManyToOne
	@JoinColumn(name = "hospital_id")
	private Hospital hospital;

	@Column(name = "fecha_cita", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date fechaCita;

	@Column(name = "hora", nullable = false)
	@Temporal(TemporalType.TIME)
	private Date hora;

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

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Date getFechaCita() {
		return fechaCita;
	}

	public void setFechaCita(Date fechaCita) {
		this.fechaCita = fechaCita;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

}
