package goya.daw2.ud6;
import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel ="personas", path="personas")
public interface RepositorioPersona extends PagingAndSortingRepository<Persona,Long>, CrudRepository<Persona,Long>{
	List<Persona> findByApellido(@Param("nombre") String nombre);
}
