package goya.daw2.ud6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import goya.daw2.ud6.model.Empleado;
@Configuration
public class CargaBaseDeDatos {
	private static final Logger log = LoggerFactory.getLogger(CargaBaseDeDatos.class);

  @Bean
  CommandLineRunner initDatabase(RepositorioEmpleado repositorio) {

    return args -> {
      log.info("Preloading " + repositorio.save(new Empleado("Bilbo Baggins", "burglar")));
      log.info("Preloading " + repositorio.save(new Empleado("Frodo Baggins", "thief")));
    };
  }
}
