package com.greta.federation.repository;

import com.greta.federation.entity.Aile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AileRepository extends JpaRepository<Aile, Integer> {
    Optional<Aile> findByNom(String nom);
}
