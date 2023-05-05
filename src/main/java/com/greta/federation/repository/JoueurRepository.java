package com.greta.federation.repository;

import com.greta.federation.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoueurRepository  extends JpaRepository<Joueur, Integer> {
    Optional<Joueur> findByNom(String nom);
}
