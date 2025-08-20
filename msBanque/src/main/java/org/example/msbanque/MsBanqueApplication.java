package org.example.msbanque;

import org.example.msbanque.entities.Compte;
import org.example.msbanque.entities.typeCompte;
import org.example.msbanque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CompteRepository compteRepository){
        return args -> {
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), typeCompte.COURANT));
            compteRepository.save(new Compte(null,Math.random()*8647,new Date(), typeCompte.EPARGNE));
            compteRepository.save(new Compte(null,Math.random()*10988,new Date(), typeCompte.COURANT));
            compteRepository.findAll().forEach(c-> System.out.println(c.toString()));
        };
    }

}
