package com.greta.federation.repository;

import com.greta.federation.entity.Billet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BilletRepository extends JpaRepository<Billet, Integer> {
}
