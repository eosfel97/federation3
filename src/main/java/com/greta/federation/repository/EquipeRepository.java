package com.greta.federation.repository;

import com.greta.federation.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipeRepository  extends JpaRepository<Equipe, Integer> {
    Optional<Equipe> findByNom(String nom);
}

