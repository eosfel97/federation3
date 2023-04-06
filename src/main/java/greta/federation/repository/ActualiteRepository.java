package greta.federation.repository;

import greta.federation.entity.Actualite;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ActualiteRepository extends JpaRepository<Actualite, Long> {
}
