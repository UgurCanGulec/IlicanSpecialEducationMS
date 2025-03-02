package com.ilicanspecialeducation.infrastructure.adapter.post.repository;

import com.ilicanspecialeducation.infrastructure.adapter.post.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
}
