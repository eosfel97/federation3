package greta.federation.repository;

import greta.federation.entity.Actualite;

import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ActualiteRepository extends JpaRepository<Actualite, Integer> {
    Optional<Actualite> findByTitre(String titre);

}
