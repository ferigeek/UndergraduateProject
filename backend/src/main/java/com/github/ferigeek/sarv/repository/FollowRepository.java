package com.github.ferigeek.sarv.repository;

import com.github.ferigeek.sarv.entity.Follow;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowRepository extends JpaRepository<Follow, Long> {
}
