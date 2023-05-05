package com.greta.federation.repository;

import com.greta.federation.entity.Actualite;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActualiteRepository extends JpaRepository<Actualite, Integer> {
    Optional<Actualite> findByTitre(String titre);

}
