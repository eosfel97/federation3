package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository  extends JpaRepository<Club, Long> {
}
