package org.example.msbanque;

import jakarta.xml.ws.Endpoint;
import org.example.msbanque.entities.Client;
import org.example.msbanque.entities.Compte;
import org.example.msbanque.entities.typeCompte;
import org.example.msbanque.repositories.ClientRepository;
import org.example.msbanque.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.stereotype.Component;

import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }
    @Bean
    public Endpoint endpoint(ApplicationContext context) {
        CompteSOAPservice service = context.getBean(CompteSOAPservice.class);
        return Endpoint.publish("http://0.0.0.0:8888/", service);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository,
                            ClientRepository clientRepository,
                            RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class); // pour afficher l'id
            Client c1 = clientRepository.save(new Client(null,"Reda",null));
            Client c2 = clientRepository.save(new Client(null,"Abdo",null));
            compteRepository.save(new Compte(null,Math.random()*9000,new Date(), typeCompte.COURANT,c1));
            compteRepository.save(new Compte(null,Math.random()*8647,new Date(), typeCompte.EPARGNE,c1));
            compteRepository.save(new Compte(null,Math.random()*10988,new Date(), typeCompte.COURANT,c2));
            compteRepository.findAll().forEach(c-> System.out.println(c.getSolde()));
        };
    }

}
