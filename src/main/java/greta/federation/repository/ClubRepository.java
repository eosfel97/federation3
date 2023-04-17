package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Club;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClubRepository  extends JpaRepository<Club, Integer> {
    Optional<Club> findByNom(String nom);

}
