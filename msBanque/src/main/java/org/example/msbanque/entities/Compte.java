package org.example.msbanque.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity @NoArgsConstructor @AllArgsConstructor @ToString
public class Compte {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;
    @Temporal( TemporalType.DATE )
    private Date date;
    @Enumerated(EnumType.STRING)
    @Column(length = 10)
    private typeCompte type;
}
