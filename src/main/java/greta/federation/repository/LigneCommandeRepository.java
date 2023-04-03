package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeRepository  extends JpaRepository<LigneCommande, Long> {
}
