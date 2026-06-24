package com.github.ferigeek.sarv.repository;

import com.github.ferigeek.sarv.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
