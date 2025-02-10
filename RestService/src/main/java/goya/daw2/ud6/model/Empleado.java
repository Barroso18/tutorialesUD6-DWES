package goya.daw2.ud6.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Empleado {
	 	@Id
	  @GeneratedValue(strategy=GenerationType.IDENTITY) 
	  private Long id;
	  private String nombre;
	  private String rol;

	  public Empleado() {}

	  public Empleado(String nombre, String rol) {

	    this.nombre = nombre;
	    this.rol = rol;
	  }

	  public Long getId() {
	    return this.id;
	  }

	  public String getNombre() {
	    return this.nombre;
	  }

	  public String getRol() {
	    return this.rol;
	  }

	  public void setId(Long id) {
	    this.id = id;
	  }

	  public void setNombre(String nombre) {
	    this.nombre = nombre;
	  }

	  public void setRol(String rol) {
	    this.rol = rol;
	  }

	  @Override
	  public boolean equals(Object o) {

	    if (this == o)
	      return true;
	    if (!(o instanceof Empleado))
	      return false;
	    Empleado empleado = (Empleado) o;
	    return Objects.equals(this.id, empleado.id) && Objects.equals(this.nombre, empleado.nombre)
	        && Objects.equals(this.rol, empleado.rol);
	  }

	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.nombre, this.rol);
	  }

	  @Override
	  public String toString() {
	    return "Employee{" + "id=" + this.id + ", nombre='" + this.nombre + '\'' + ", role='" + this.rol + '\'' + '}';
	  }
}
