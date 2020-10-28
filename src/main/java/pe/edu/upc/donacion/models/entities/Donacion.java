package pe.edu.upc.donacion.models.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "donaciones")
public class Donacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@OneToOne(mappedBy = "donacion")
	private UnidadSangre unidadSangre;

	@Column(name = "fecha_donacion", nullable = false)
	@Temporal(TemporalType.DATE)
	private Date FechaDonacion;

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

}
