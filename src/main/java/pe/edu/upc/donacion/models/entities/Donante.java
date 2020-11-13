package pe.edu.upc.donacion.models.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "donantes")
public class Donante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "email", unique = true, nullable = false)
	private String email;
	
	@Column(name = "contraseña", nullable = false)
	private String contraseña;
	
	@Column(name = "nombres_apellidos", nullable = false)
	private String nombresApellidos;
	
	@Column(name = "numero_documento", length = 12, unique = true, nullable = false)
	private String numeroDocumento;
	
	@Column(name ="fecha_nacimiento")
	@Temporal(TemporalType.DATE)
	private Date fechaNacimiento;
	
	@Column(name = "direccion", nullable = false)
	private String direccion;
	
	@ManyToOne
	@JoinColumn(name = "distrito_id")
	private Distrito distrito;
	
	@Transient
	private Integer distritoId;
	
	@ManyToOne
	@JoinColumn(name = "tipoSangre_id")
	private TipoSangre tipoSangre;
	
	@Transient
	private Integer tipoSangreId;
	
	@OneToMany(mappedBy = "donante")
	private List<RegistroDonacion> registrosDonaciones;
	
	@OneToMany(mappedBy = "donante")
	private List<FichaMedica> fichasMedicas;
	
	@OneToMany(mappedBy = "donante")
	private List<Cita> citas;
	
	public Donante() {
		registrosDonaciones = new ArrayList<RegistroDonacion>();
		fichasMedicas = new ArrayList<FichaMedica>();
		citas = new ArrayList<Cita>();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	public String getNombresApellidos() {
		return nombresApellidos;
	}

	public void setNombresApellidos(String nombresApellidos) {
		this.nombresApellidos = nombresApellidos;
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Distrito getDistrito() {
		return distrito;
	}

	public void setDistrito(Distrito distrito) {
		this.distrito = distrito;
		if (this.distrito != null ) {
			this.distritoId = this.distrito.getId();
		}
	}

	public Integer getDistritoId() {
		if (this.distritoId <= 0 && this.distrito != null) {
			this.distritoId = this.distrito.getId();
		}
		return distritoId;
	}

	public void setDistritoId(Integer ditritoId) {
		this.distritoId = ditritoId;
	}

	public TipoSangre getTipoSangre() {
		return tipoSangre;
	}

	public void setTipoSangre(TipoSangre tipoSangre) {
		this.tipoSangre = tipoSangre;
		if (this.tipoSangre != null) {
			this.tipoSangreId = this.tipoSangre.getId();
		}
	}

	public Integer getTipoSangreId() {
		if (this.tipoSangreId <= 0 && this.tipoSangre != null) {
			this.tipoSangreId = this.tipoSangre.getId();
		}
		return tipoSangreId;
	}

	public void setTipoSangreId(Integer tipoSangreId) {
		this.tipoSangreId = tipoSangreId;
	}

	public List<RegistroDonacion> getRegistrosDonaciones() {
		return registrosDonaciones;
	}

	public void setRegistrosDonaciones(List<RegistroDonacion> registrosDonaciones) {
		this.registrosDonaciones = registrosDonaciones;
	}

	public List<FichaMedica> getFichasMedicas() {
		return fichasMedicas;
	}

	public void setFichasMedicas(List<FichaMedica> fichasMedicas) {
		this.fichasMedicas = fichasMedicas;
	}

	public List<Cita> getCitas() {
		return citas;
	}

	public void setCitas(List<Cita> citas) {
		this.citas = citas;
	}
	
	
	
}
