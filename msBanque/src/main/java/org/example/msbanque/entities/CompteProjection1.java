package org.example.msbanque.entities;

import org.springframework.data.rest.core.config.Projection;

//doit etre au meme package que Compte pour sa marche
//apres /api/comptes?projection=solde
//il affiche que le solde
@Projection(name = "solde", types = Compte.class)
public interface CompteProjection1 {
    public double getSolde();
}
