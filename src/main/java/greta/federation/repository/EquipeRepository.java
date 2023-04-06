package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipeRepository  extends JpaRepository<Equipe, Long> {
}
