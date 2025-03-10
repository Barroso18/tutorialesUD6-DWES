package goya.daw2.ud6;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("peliculas")
@RestController
public class PeliculaController {
	private final RepositorioPelicula repositorio;
	public PeliculaController(RepositorioPelicula repositorio) {
		this.repositorio = repositorio;
	}
	/*List<Pelicula> all() {
	    return repositorio.findAll();
	}*/
	@GetMapping("/")
	public ResponseEntity<Iterable<Pelicula>> getAllPeliculas() {
        return ResponseEntity.ok(repositorio.findAll());
    }
	
	@GetMapping("/{id}")
    public ResponseEntity<Pelicula> getPeliculaById(@PathVariable("id") Long id) {
        return repositorio.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
	
	@PostMapping("/")
    public ResponseEntity<?> createPelicula(@RequestBody Pelicula pelicula) {
        
        if (repositorio.findByNombre(pelicula.getNombre()).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("NOMBRE YA EXISTENTE");
        }
        Pelicula savedPelicula = repositorio.save(pelicula);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPelicula);
    }
	
	
	@PutMapping("/{id}")
	public ResponseEntity<String> replaceOrCreatePelicula(@PathVariable("id") Long id, @RequestBody Pelicula pelicula){
		if (!id.equals(pelicula.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CONFLICTO DE IDs");
        }
		// Verifica si el nombre ya existe en otro personaje
        if (repositorio.findByNombre(pelicula.getNombre()).isPresent() && 
        		!id.equals(repositorio.findByNombre(pelicula.getNombre()).get().getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("NOMBRE YA EXISTENTE");
        }
		// Guarda el personaje (ya sea actualización o creación)
        repositorio.save(pelicula);
		// Respuesta diferente si se creó o se actualizó
        return repositorio.existsById(id) 
            ? ResponseEntity.ok("Película actualizada con éxito") 
            : ResponseEntity.status(HttpStatus.CREATED).body("Película creada con éxito");
	}
	
	@PatchMapping("/{id}")
    public ResponseEntity<?> updatePelicula(@PathVariable("id") Long id, @RequestBody Pelicula pelicula) {
        Optional<Pelicula> existingPelicula = repositorio.findById(id);
        if (!existingPelicula.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        
        Pelicula updatedPelicula = existingPelicula.get();
        if (pelicula.getNombre() != null) {
            if (repositorio.findByNombre(pelicula.getNombre()).isPresent()) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("NOMBRE YA EXISTENTE");
            }
            updatedPelicula.setNombre(pelicula.getNombre());
        }
        repositorio.save(updatedPelicula);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
	
	 @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePelicula(@PathVariable("id") Long id) {
        if (!repositorio.existsById(id)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        repositorio.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
