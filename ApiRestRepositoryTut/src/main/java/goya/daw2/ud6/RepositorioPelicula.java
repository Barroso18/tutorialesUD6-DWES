package goya.daw2.ud6;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel ="peliculas", path="peliculas")
public interface RepositorioPelicula extends PagingAndSortingRepository<Pelicula,Long>, CrudRepository<Pelicula,Long>{
	List<Pelicula> findByNombre(@Param("nombre") String nombre);
}
