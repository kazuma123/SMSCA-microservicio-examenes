package com.app.microserviciosexamenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan({"com.app.commonsexamenes.models"})
public class MicroserviciosExamenesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciosExamenesApplication.class, args);
	}

}
