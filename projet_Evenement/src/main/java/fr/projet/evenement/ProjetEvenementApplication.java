package fr.projet.evenement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan("fr.projet.evenement.entity")
public class ProjetEvenementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetEvenementApplication.class, args);
	}
}
