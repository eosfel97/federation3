package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.Rencontre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RencontreRepository  extends JpaRepository<Rencontre, Integer> {
}
