package goya.daw2.ud6;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("peliculas")
@RestController
public class PeliculaController {
	private final RepositorioPelicula repositorio;
	public PeliculaController(RepositorioPelicula repositorio) {
		this.repositorio = repositorio;
	}
	
	@GetMapping("/")
	/*List<Pelicula> all() {
	    return repositorio.findAll();
	}*/
	public ResponseEntity<Iterable<Pelicula>> getAllPeliculas() {
        return ResponseEntity.ok(repositorio.findAll());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable("id") Long id) {
        return repositorio.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
