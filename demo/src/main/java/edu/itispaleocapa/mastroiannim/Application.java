package edu.itispaleocapa.mastroiannim;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"edu.itispaleocapa.mastroiannim.controllers", 
											"edu.itispaleocapa.mastroiannim.services"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
