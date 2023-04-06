package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Joueur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoueurRepository  extends JpaRepository<Joueur, Long> {
}
