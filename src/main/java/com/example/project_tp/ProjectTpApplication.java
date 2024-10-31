package com.example.project_tp;

import com.example.project_tp.entities.Compte;
import com.example.project_tp.entities.Compte.TypeCompte;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import com.example.project_tp.repository.CompteRepository;

import java.util.Date;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.project_tp")
public class ProjectTpApplication {
	public static void main(String[] args) {

		SpringApplication.run(ProjectTpApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository) {
		return args -> {
			compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
			compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.COURANT));
			compteRepository.save(new Compte(null, Math.random() * 9000, new Date(), TypeCompte.EPARGNE));
			compteRepository.findAll().forEach(c -> {
				System.out.println(c.toString());
			});
		};
	}
}
