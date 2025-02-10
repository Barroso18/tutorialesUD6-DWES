package goya.daw2.ud6;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import goya.daw2.ud6.model.Empleado;
@RequestMapping("empleados")
@RestController
public class ControladorEmpleado {
	RepositorioEmpleado repositorio;
	
	 public ControladorEmpleado(RepositorioEmpleado repositorio) {
	    this.repositorio = repositorio;
	  }


		  // Aggregate root
		  // tag::get-aggregate-root[]
		  //@GetMapping("/empleados")
	 		@GetMapping("/")
		  List<Empleado> all() {
		    return repositorio.findAll();
		  }
		  // end::get-aggregate-root[]

		  //@PostMapping("/empleados")
		  @PostMapping("/")
		  Empleado nuevoEmpleado(@RequestBody Empleado nuevoEmpleado) {
		    return repositorio.save(nuevoEmpleado);
		  }

		  // Single item
		  
		  //@GetMapping("/empleados/{id}")
		  @GetMapping("/{id}")
		  Empleado one(@PathVariable(name="id") Long id) {
		    //return repositorio.findById(id).orElseThrow(() -> new EmpleadoNoEncontradoException(id));
			  Optional<Empleado> empleadoOpt = repositorio.findById(id);
			  if(empleadoOpt.isPresent()) {
				  return empleadoOpt.get();
			  }
			  throw new EmpleadoNoEncontradoException(id);
		  }

		  //@PutMapping("/empleados/{id}")
		  @PutMapping("/{id}")
		  Empleado reemplazaEmpleado(@RequestBody Empleado nuevoEmpleado, @PathVariable(name="id") Long id) {
			  Optional<Empleado> empleadoOpt = repositorio.findById(id);
			  if(empleadoOpt.isPresent()) {
				  Empleado empleado = empleadoOpt.get();
				  empleado.setNombre(nuevoEmpleado.getNombre());
				  empleado.setRol(nuevoEmpleado.getRol());
				  return repositorio.save(empleado);
			  }
			  return repositorio.save(nuevoEmpleado);
			  /*return repositorio.findById(id).map(empleado -> {
				  empleado.setName(nuevoEmpleado.getName());
				  empleado.setRole(nuevoEmpleado.getRole());
		        return repositorio.save(empleado);
		      })
		      .orElseGet(() -> {
		        return repositorio.save(nuevoEmpleado);
		      });*/
		  }

		  //@DeleteMapping("/empleados/{id}")
		  @DeleteMapping("/{id}")
		  void borraEmpleado(@PathVariable(name="id") Long id) {
			  repositorio.deleteById(id);
		  }
}
