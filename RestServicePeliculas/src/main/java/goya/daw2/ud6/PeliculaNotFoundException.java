package goya.daw2.ud6;

public class PeliculaNotFoundException extends RuntimeException{
	PeliculaNotFoundException(Long id) {
	    super("No se puede encontrar la película " + id);
	  }
}
