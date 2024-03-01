package modelo.entidad.nacho;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name= "direcciones")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Integer id;
	private String calle;
	private Integer cp;
	private String localidad;
	
	@OneToOne
	@JoinColumn (name = "fk_id_taller" , referencedColumnName="id")
	private Taller taller;

	public Direccion() {
		super();
		
	}

	public Direccion(Integer id, String calle, Integer cp, String localidad, Taller taller) {
		super();
		this.id = id;
		this.calle = calle;
		this.cp = cp;
		this.localidad = localidad;
		this.taller = taller;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getCp() {
		return cp;
	}

	public void setCp(Integer cp) {
		this.cp = cp;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public Taller getTaller() {
		return taller;
	}

	public void setTaller(Taller taller) {
		this.taller = taller;
	}

	@Override
	public String toString() {
		return "Direccion [id=" + id + ", calle=" + calle + ", cp=" + cp + ", localidad=" + localidad + ", taller="
				+ taller + "]";
	}
	
	

}
