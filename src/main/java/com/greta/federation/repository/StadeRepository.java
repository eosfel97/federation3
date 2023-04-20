package com.greta.federation.repository;

import com.greta.federation.entity.Stade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StadeRepository  extends JpaRepository<Stade, Integer> {
    Optional<Stade> findByNom(String nom);

}
