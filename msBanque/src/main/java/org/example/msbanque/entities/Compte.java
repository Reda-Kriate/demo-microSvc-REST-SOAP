package org.example.msbanque.entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter @Setter //getters setters
@NoArgsConstructor @AllArgsConstructor //constructor with and with no arguments
@ToString // tostring methode
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal( TemporalType.DATE )
    private Date date;
    @Enumerated(EnumType.STRING) //ENUM de type string
    @Column(length = 10) //modifier length
    private typeCompte type;
}
