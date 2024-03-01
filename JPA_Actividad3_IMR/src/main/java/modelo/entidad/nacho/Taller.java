package modelo.entidad.nacho;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "talleres")
public class Taller {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY )
	private Integer id;
	private String nombre;
	
	@OneToOne (mappedBy = "taller", cascade = CascadeType.ALL)
	private Direccion direccion;

	public Taller() {
		super();
		
	}

	public Taller(Integer id, String nombre, Direccion direccion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
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

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@Override
	public String toString() {
		return "Taller [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	

}
