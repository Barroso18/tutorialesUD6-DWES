package goya.daw2.ud6;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class PeliculaNotFoundAdvice {
	@ExceptionHandler(PeliculaNotFoundException.class)
	  @ResponseStatus(HttpStatus.NOT_FOUND)
	  String employeeNotFoundHandler(PeliculaNotFoundException ex) {
	    return ex.getMessage();
	  }
}
