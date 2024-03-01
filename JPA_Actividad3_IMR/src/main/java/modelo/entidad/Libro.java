package modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import javax.xml.bind.annotation.XmlType;


@XmlRootElement
@XmlType(propOrder = {"id", "titulo", "precio", "autor", "editorial"})

@Entity
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private double precio;
	
	@ManyToOne
	@JoinColumn(name="FK_EDITORIAL", referencedColumnName="id")
	private Editorial editorial;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_AUTOR", referencedColumnName = "id")    
	private Autor autor;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="libros_bibliotecas",
	   joinColumns= { @JoinColumn(name="FK_ID_LIBRO", referencedColumnName="id") }, 
	   inverseJoinColumns= { @JoinColumn(name="FK_ID_LIBRERIA", referencedColumnName="id")}) 
	private List<Libreria>librerias = new ArrayList<Libreria>();
	

	public Libro() {
		super();
	}


	public Libro(Integer id, String titulo, double precio, Editorial editorial, Autor autor) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.autor = autor;
	}


	@XmlAttribute(name = "id")
	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public Editorial getEditorial() {
		return editorial;
	}


	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}


	public Autor getAutor() {
		return autor;
	}


	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	//@XmlElement (name = "libreria")
	//@XmlElementWrapper (name = "librerias")
	@XmlTransient
	public List<Libreria> getLibrerias() {
		return librerias;
	}


	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}


	@Override
	public String toString() {
		return "Libro [id=" + id + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial + ", autor="
				+ autor + "]";
	}
	
	
	
}
