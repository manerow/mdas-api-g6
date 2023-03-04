package com.mdas.api.g6;


import com.mdas.api.g6.infrastructure.console.ConsoleController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class PokeApiApplication {

	public static void main(String[] args) {

		SpringApplication app = new SpringApplication(PokeApiApplication.class);
		if (Arrays.asList(args).contains("console")) {
			app.setWebApplicationType(WebApplicationType.NONE);
			ApplicationContext context = app.run(args);
			ConsoleController consoleController = context.getBean(ConsoleController.class);
			consoleController.run();
		} else {
			app.run(args);
		}
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
