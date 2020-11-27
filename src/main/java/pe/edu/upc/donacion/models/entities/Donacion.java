package pe.edu.upc.donacion.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "donaciones")
public class Donacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne
	@JoinColumn(name="unidadSangre_id")
	private UnidadSangre unidadSangre;

	@Column(name = "fecha_donacion", nullable = false)
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	private Date FechaDonacion;
	
	@ManyToOne
	@JoinColumn(name = "donante_id")
	private Donante donante;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UnidadSangre getUnidadSangre() {
		return unidadSangre;
	}

	public void setUnidadSangre(UnidadSangre unidadSangre) {
		this.unidadSangre = unidadSangre;
	}

	public Date getFechaDonacion() {
		return FechaDonacion;
	}

	public void setFechaDonacion(Date fechaDonacion) {
		FechaDonacion = fechaDonacion;
	}

	public Donante getDonante() {
		return donante;
	}

	public void setDonante(Donante donante) {
		this.donante = donante;
	}
}
