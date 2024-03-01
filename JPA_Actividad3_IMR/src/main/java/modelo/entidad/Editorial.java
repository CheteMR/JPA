package modelo.entidad;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement
@XmlType(propOrder = {"id", "nombre", "direccion"})

@Entity
public class Editorial {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;

	@OneToMany(mappedBy = "editorial", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Libro> librosEditorial;

	@Embedded
	private Direccion direccion;

	public Editorial() {
		super();
	}

	public Editorial(Integer id, String nombre, List<Libro> librosEditorial) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.librosEditorial = librosEditorial;
	}

	@XmlAttribute(name = "id")
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

	//@XmlElement (name = "libro")
	//@XmlElementWrapper (name = "librosEditorial")
	@XmlTransient
	public List<Libro> getLibrosEditorial() {
		return librosEditorial;
	}

	public void setLibrosEditorial(List<Libro> librosEditorial) {
		this.librosEditorial = librosEditorial;
	}

}
