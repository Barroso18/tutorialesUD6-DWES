package goya.daw2.ud6;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pelicula {
	@Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	 private String nombre;
	  private String director;
	  private String clasificacion;
	  /*public Pelicula(String nombre, String director,String clasificacion) {
		  this.nombre = nombre;
		  this.director = director;
		  this.clasificacion = new Clasificacion(clasificacion);
	  }*/
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	/*public Clasificacion getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(Clasificacion clasificacion) {
		this.clasificacion = clasificacion;
	}*/
	public String getClasificacion() {
		return clasificacion;
	}
	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}
	
}
