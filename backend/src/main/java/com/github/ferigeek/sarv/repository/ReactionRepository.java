package com.github.ferigeek.sarv.repository;

import com.github.ferigeek.sarv.entity.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {
}
