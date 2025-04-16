package com.example.climaAPI;

import com.example.climaAPI.controller.Principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClimaApiApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ClimaApiApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal();
		principal.Iniciar();
	}

}
