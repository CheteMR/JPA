package modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder = {"id", "nombre", "nombreDueño", "direccion", "libros"})

@Entity
public class Libreria {
	// Un libro puede estar en diferentes librerías y varias librerías pueden almacenar varios libros.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre,nombreDueño;
	
	@Embedded
	private Direccion direccion;
	
	
	@ManyToMany(mappedBy="librerias", cascade=CascadeType.PERSIST)
	private List<Libro>libros = new ArrayList<Libro>();
	
	public Libreria() {
		super();
	}

	public Libreria(Integer id, String nombre, String nombreDueño, List<Libro> libros) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.nombreDueño = nombreDueño;
		this.libros = libros;
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

	public String getNombreDueño() {
		return nombreDueño;
	}

	public void setNombreDueño(String nombreDueño) {
		this.nombreDueño = nombreDueño;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	@XmlElement (name = "libro")
	@XmlElementWrapper (name = "libros")	
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}

	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", nombreDueño=" + nombreDueño + ", direccion=" + direccion
				+ ", libros=" + libros + "]";
	}

	public void agregarLibro(Libro lib1) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
