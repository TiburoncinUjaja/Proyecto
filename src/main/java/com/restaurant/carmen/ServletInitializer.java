package com.restaurant.carmen;

/**
 * Clase ServletInitializer para la configuración de la aplicación Carmen al desplegarse en un contenedor servlet.
 * Extiende SpringBootServletInitializer para proporcionar la configuración necesaria.
 */



import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {
	
	/**
     * Configura la aplicación SpringBoot al desplegarse en un contenedor servlet.
     *
     * @param application La aplicación SpringBoot a configurar.
     * @return La aplicación SpringBoot configurada.
     */

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CarmenApplication.class);
	}

}
