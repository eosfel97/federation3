package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Saison;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaisonRepository  extends JpaRepository<Saison, Integer> {
}
