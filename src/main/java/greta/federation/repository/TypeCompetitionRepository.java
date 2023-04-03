package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.TypeCompetition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeCompetitionRepository  extends JpaRepository<TypeCompetition, Long> {
}
