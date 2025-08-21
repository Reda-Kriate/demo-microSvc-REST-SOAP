package org.example.msbanque.web;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.msbanque.entities.Compte;
import org.example.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//REST baser sur JaxRS -> Jersey
@Component
@Path("/banque")
public class CompteRESTJaxRsAPI {

    @Autowired //IOC
    private CompteRepository compteRepository;

    @GET //Methode HTTP
    @Path("/comptes") //Path de methode
    @Produces(MediaType.APPLICATION_JSON) //Format qui accepte
    public List<Compte> listComptes(){
        return compteRepository.findAll();
    }
    @GET //Methode HTTP
    @Path("/comptes/{id}") //Path de methode
    @Produces(MediaType.APPLICATION_JSON) //Format qui accepte
    public Compte getOne(@PathParam(value = "id") Long id){
        return compteRepository.findById(id).get();
    }
    @POST //Methode HTTP
    @Path("/comptes") //Path de methode
    @Produces(MediaType.APPLICATION_JSON) //Format qui accepte
    public Compte save(Compte compte){
        return compteRepository.save(compte);
    }
    @PUT //Methode HTTP
    @Path("/comptes/{id}") //Path de methode
    @Produces(MediaType.APPLICATION_JSON) //Format qui accepte
    public Compte update(@PathParam("id") Long id,Compte compte){
        compte.setId(id);
        return compteRepository.save(compte);
    }
    @DELETE //Methode HTTP
    @Path("/comptes/{id}") //Path de methode
    @Produces(MediaType.APPLICATION_JSON) //Format qui accepte
    public void delete(@PathParam("id") Long id){
         compteRepository.deleteById(id);
    }
}
