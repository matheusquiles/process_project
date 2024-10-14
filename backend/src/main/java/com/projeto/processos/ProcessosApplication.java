package com.projeto.processos;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProcessosApplication {

	public static void main(String[] args) {
//		SpringApplication.run(ProcessosApplication.class, args);
		
		String port = System.getenv("PORT");
	    if (port == null || port.isEmpty()) {
	        port = "8080";
	    }
	    int portNumber = Integer.parseInt(port);
	    // Configurar o servidor para usar a porta `portNumber`
	    // Exemplo com Spring Boot
	    SpringApplication app = new SpringApplication(ProcessosApplication.class);
	    app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
	    app.run(args);
	}

}
