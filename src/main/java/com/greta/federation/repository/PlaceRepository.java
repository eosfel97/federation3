package com.greta.federation.repository;

import com.greta.federation.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlaceRepository extends JpaRepository<Place, Integer> {

    List<Place> findByAile(String aile);

    List<Place> findByLigne(String ligne);

    List<Place> findByNumLigne(String numLigne);

    List<Place> findByStadeId(Integer idStade);

}
