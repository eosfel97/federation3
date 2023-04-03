package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.EvenementRencontre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenementRencontreRepository  extends JpaRepository<EvenementRencontre, Long> {
}
