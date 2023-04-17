package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Equipe;
import net.bytebuddy.jar.asm.commons.Remapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EquipeRepository  extends JpaRepository<Equipe, Integer> {
    Optional<Equipe> findByNom(String nom);
}

