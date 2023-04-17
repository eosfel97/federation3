package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JoueurRepository  extends JpaRepository<Joueur, Integer> {
    Optional<Joueur> findByNom(String nom);
}
