package goya.daw2.ud6;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import goya.daw2.ud6.model.Empleado;
@Repository
public interface RepositorioEmpleado extends JpaRepository<Empleado, Long>{
	//Optional<Empleado> 
}
