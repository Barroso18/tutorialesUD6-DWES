package goya.daw2.ud6;

public class EmpleadoNoEncontradoException extends RuntimeException{
	EmpleadoNoEncontradoException(Long id) {
	    super("No encuentro el empleado " + id);
	  }
}
