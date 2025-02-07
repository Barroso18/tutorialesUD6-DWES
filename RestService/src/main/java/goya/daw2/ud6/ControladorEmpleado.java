package goya.daw2.ud6;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import goya.daw2.ud6.model.Empleado;

@RestController
public class ControladorEmpleado {
	RepositorioEmpleado repositorio;
	
	 public ControladorEmpleado(RepositorioEmpleado repositorio) {
	    this.repositorio = repositorio;
	  }


		  // Aggregate root
		  // tag::get-aggregate-root[]
		  @GetMapping("/empleados")
		  List<Empleado> all() {
		    return repositorio.findAll();
		  }
		  // end::get-aggregate-root[]

		  @PostMapping("/empleados")
		  Empleado nuevoEmpleado(@RequestBody Empleado nuevoEmpleado) {
		    return repositorio.save(nuevoEmpleado);
		  }

		  // Single item
		  
		  @GetMapping("/empleados/{id}")
		  Empleado one(@PathVariable Long id) {
		    return repositorio.findById(id).orElseThrow(() -> new EmpleadoNoEncontradoException(id));
		  }

		  @PutMapping("/empleados/{id}")
		  Empleado reemplazaEmpleado(@RequestBody Empleado nuevoEmpleado, @PathVariable Long id) {
		    
			  return repositorio.findById(id).map(empleado -> {
				  empleado.setName(nuevoEmpleado.getName());
				  empleado.setRole(nuevoEmpleado.getRole());
		        return repositorio.save(empleado);
		      })
		      .orElseGet(() -> {
		        return repositorio.save(nuevoEmpleado);
		      });
		  }

		  @DeleteMapping("/empleados/{id}")
		  void borraEmpleado(@PathVariable Long id) {
			  repositorio.deleteById(id);
		  }
}
