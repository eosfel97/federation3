package greta.federation.repository;

import greta.federation.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CommandeRepository  extends JpaRepository<Commande, Integer> {
    Optional<Commande> findCommandeByDateCommande(LocalDateTime dateCommande);
    List<Commande> findAllByUserId(Integer id);
}
