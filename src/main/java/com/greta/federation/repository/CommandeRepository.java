package com.greta.federation.repository;

import com.greta.federation.entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface CommandeRepository  extends JpaRepository<Commande, Integer> {
    List<Commande> findByDateCommande(LocalDateTime dateCommande);

}
