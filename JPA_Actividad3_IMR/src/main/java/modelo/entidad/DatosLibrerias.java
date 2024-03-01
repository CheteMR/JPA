package modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="datosLibrerias")
public class DatosLibrerias {
	private List<Autor> autores;
	private List<Direccion> direcciones;
	private List<Editorial> editoriales;
	private List<Libreria> librerias;
	private List<Libro> libros;
	
	public DatosLibrerias() {
		autores = new ArrayList<Autor>();
		direcciones = new ArrayList<Direccion>();
		editoriales = new ArrayList<Editorial>();
		librerias = new ArrayList<Libreria>();
		libros = new ArrayList<Libro>();
	}
	
	@XmlElement(name = "autor")
	@XmlElementWrapper(name = "autores")
	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}
	
	public List<Direccion> getDirecciones() {
		return direcciones;
	}

	public void setDirecciones(List<Direccion> direcciones) {
		this.direcciones = direcciones;
	}
	
	@XmlElement(name = "editorial")
	@XmlElementWrapper(name = "editoriales")
	public List<Editorial> getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(List<Editorial> editoriales) {
		this.editoriales = editoriales;
	}
	
	@XmlElement(name = "libreria")
	@XmlElementWrapper(name = "librerias")
	public List<Libreria> getLibrerias() {
		return librerias;
	}

	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}
	
	@XmlElement(name = "libro")
	@XmlElementWrapper(name = "libros")
	public List<Libro> getLibros() {
		return libros;
	}

	public void setLibros(List<Libro> libros) {
		this.libros = libros;
	}
	
	
	
}
