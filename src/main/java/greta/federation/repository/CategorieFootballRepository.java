package greta.federation.repository;

import greta.federation.entity.Actualite;
import greta.federation.entity.CategorieFootball;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieFootballRepository  extends JpaRepository<CategorieFootball, Long> {
}
