package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Stade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StadeRepository  extends JpaRepository<Stade, Long> {
}
