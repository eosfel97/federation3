package com.greta.federation.repository;

import com.greta.federation.entity.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository  extends JpaRepository<Competition, Integer> {
}
