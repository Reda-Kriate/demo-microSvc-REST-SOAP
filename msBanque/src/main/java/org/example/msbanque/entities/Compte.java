package org.example.msbanque.entities;


import jakarta.persistence.*;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;
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
    @ManyToOne
    private Client client;
}
