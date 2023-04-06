package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommandeRepository  extends JpaRepository<Commande, Long> {
}
