package org.example.msbanque;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.example.msbanque.entities.Compte;
import org.example.msbanque.repositories.CompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

//Creation se WS SOPA JaxWS
@Component
@WebService(name = "WSbanque")
public class CompteSOAPservice {

    @Autowired //IOC
    private CompteRepository compteRepository;

    @WebMethod
    public List<Compte> listComptes(){
        return compteRepository.findAll();
    }
    @WebMethod
    public Compte getOne(@WebParam(name = "id") Long id){
        return compteRepository.findById(id).get();
    }
}
