package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Arbitre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArbitreRepository  extends JpaRepository<Arbitre, Long> {
}
