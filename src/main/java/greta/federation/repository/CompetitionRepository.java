package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository  extends JpaRepository<Competition, Integer> {
}
