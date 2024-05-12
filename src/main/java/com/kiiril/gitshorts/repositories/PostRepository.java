package com.kiiril.gitshorts.repositories;

import com.kiiril.gitshorts.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
