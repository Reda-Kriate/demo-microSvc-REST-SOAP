package org.example.msbanque.repositories;

import org.example.msbanque.entities.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte,Long> {
}
