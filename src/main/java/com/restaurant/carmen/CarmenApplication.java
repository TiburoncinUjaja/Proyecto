package com.restaurant.carmen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal para la aplicación Carmen.
 * Esta clase contiene el método principal para iniciar la aplicación.
 */

@SpringBootApplication
public class CarmenApplication {
	
	/**
     * Punto de entrada para la aplicación Carmen.
     *
     * @param args Los argumentos de línea de comandos pasados a la aplicación.
     */

    public static void main(String[] args) {
        SpringApplication.run(CarmenApplication.class, args);
    }
}

