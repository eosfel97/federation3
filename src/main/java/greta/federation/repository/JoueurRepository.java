package greta.federation.repository;

import greta.federation.entity.Joueur;
import greta.federation.entity.Poste;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JoueurRepository extends JpaRepository<Joueur, Long> {
    @Query("select p from Poste p")
    public List<Poste> listPostes();

}
