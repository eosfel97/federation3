package com.greta.federation.repository;


import com.greta.federation.entity.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategorieRepository extends JpaRepository<Categorie, Integer> {
    Optional<Categorie> findCategorieByNom(String nom);
}
