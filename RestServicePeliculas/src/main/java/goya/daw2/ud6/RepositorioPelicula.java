package goya.daw2.ud6;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioPelicula extends JpaRepository<Pelicula,Long>{
	Optional<Pelicula> findByNombre(@Param("nombre") String nombre);
	public Optional<Pelicula> findById(Long id);
}
