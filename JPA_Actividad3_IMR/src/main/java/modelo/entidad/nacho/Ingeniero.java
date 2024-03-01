package modelo.entidad.nacho;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ingenieros")
public class Ingeniero {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private Integer telefono;
	private String departamento;
	
	@ManyToOne
	@JoinColumn(name="fk_id_taller", referencedColumnName="id")
	private Taller taller;
	
	@ManyToMany(mappedBy="ingenieros", cascade=CascadeType.PERSIST)
	private List <Camper> campers;

	public Ingeniero() {
		super();
		
	}

	public Ingeniero(Integer id, String nombre, Integer telefono, String departamento, Taller taller,
			List<Camper> campers) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
		this.departamento = departamento;
		this.taller = taller;
		this.campers = campers;
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

	public Integer getTelefono() {
		return telefono;
	}

	public void setTelefono(Integer telefono) {
		this.telefono = telefono;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public Taller getTaller() {
		return taller;
	}

	public void setTaller(Taller taller) {
		this.taller = taller;
	}

	public List<Camper> getCampers() {
		return campers;
	}

	public void setCampers(List<Camper> campers) {
		this.campers = campers;
	}

	@Override
	public String toString() {
		return "Ingeniero [id=" + id + ", nombre=" + nombre + ", telefono=" + telefono + ", departamento="
				+ departamento + ", taller=" + taller + ", campers=" + campers + "]";
	}
	
	
	

}
