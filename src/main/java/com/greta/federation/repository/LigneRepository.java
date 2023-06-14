package com.greta.federation.repository;

import com.greta.federation.entity.Aile;
import com.greta.federation.entity.Ligne;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LigneRepository extends JpaRepository<Ligne, Integer> {
    Optional<Ligne> findByNom(String nom);

}
