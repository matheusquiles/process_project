package com.projeto.processos;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.projeto.processos.config.BuildInfo;

@SpringBootApplication
public class ProcessosApplication {

	public static void main(String[] args) {
		
		BuildInfo.printBuildDetails();
		
		String port = System.getenv("PORT");
		if (port == null || port.isEmpty()) {
			port = "8080";
		}
		int portNumber = Integer.parseInt(port);
		SpringApplication app = new SpringApplication(ProcessosApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", portNumber));
		app.run(args);
	}

}
