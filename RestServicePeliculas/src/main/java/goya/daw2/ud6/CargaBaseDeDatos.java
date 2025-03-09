package goya.daw2.ud6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CargaBaseDeDatos {
	private static final Logger log = LoggerFactory.getLogger(CargaBaseDeDatos.class);

  @Bean
  CommandLineRunner initDatabase(RepositorioPelicula repositorio) {

    return args -> {
     /* log.info("Preloading " + repositorio.save(new Pelicula("El sexto sentido","M. Night Shyamalan","Drama")));
      log.info("Preloading " + repositorio.save(new Pelicula("Pulp Fiction","Tarantino","Acción")));*/
    };
  }
}
