package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Stade;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StadeRepository  extends JpaRepository<Stade, Integer> {
    Optional<Stade> findByNom(String nom);

}
