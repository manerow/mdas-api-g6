package com.mdas.api.g6;


import com.mdas.api.g6.infrastructure.console.ConsoleController;
import com.mdas.api.g6.infrastructure.http.controller.PokeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class PokeApiApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(PokeApiApplication.class, args);

		// Inicializamos el controller del Rest API
		PokeController restApiController = context.getBean(PokeController.class);

		// Inicializamos el controller de la consola
		ConsoleController consoleController = context.getBean(ConsoleController.class);
		// se ejecuta el método que contiene la lógica de la consola
		consoleController.run();
		// Mantenemos el contexto de Spring activo para que no se detengan los controllers
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
