package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.LigneCommande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LigneCommandeRepository  extends JpaRepository<LigneCommande, Integer> {
    List<LigneCommande> findAllByCommandeId(Integer id);

    List<LigneCommande> findAllByArticleId(Integer id);
}
