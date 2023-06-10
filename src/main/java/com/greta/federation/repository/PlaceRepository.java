package com.greta.federation.repository;

import com.greta.federation.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {


    List<Place> findByLigne(String nom);
}
