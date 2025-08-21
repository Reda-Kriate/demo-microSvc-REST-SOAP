package org.example.msbanque.entities;

import org.springframework.data.rest.core.config.Projection;

//doit etre au meme package que Compte pour sa marche
//apres /api/comptes?projection=mobile
//il affiche que le solde et le type
//on specifier les attributs mais en cote backend pas en cote client / la difference entre rest et graphQl
@Projection(name = "mobile" , types = Compte.class)
public interface CompteProjection2 {
    public double getSolde();
    public typeCompte getType();
}
