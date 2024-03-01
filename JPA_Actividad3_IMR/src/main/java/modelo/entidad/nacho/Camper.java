package modelo.entidad.nacho;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table ( name = "campers")
public class Camper {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca, modelo,matricula;
	
	@ManyToMany (cascade=CascadeType.PERSIST)
	@JoinTable (name ="ingenieros_campers", 
			joinColumns= { @JoinColumn(name="fk_id_ingeniero", referencedColumnName="id") },
			inverseJoinColumns= { @JoinColumn(name="fk_id_camper", referencedColumnName="id")})
	
	private List<Ingeniero> ingenieros;
	
	public Camper() {
		super();
	}

	public Camper(Integer id, String marca, String modelo, String matricula, List<Ingeniero> ingenieros) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.matricula = matricula;
		this.ingenieros = ingenieros;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Ingeniero> getIngenieros() {
		return ingenieros;
	}

	public void setIngenieros(List<Ingeniero> ingenieros) {
		this.ingenieros = ingenieros;
	}

	@Override
	public String toString() {
		return "Camper [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", matricula=" + matricula
				+ ", ingenieros=" + ingenieros + "]";
	}
	
	
	

}
