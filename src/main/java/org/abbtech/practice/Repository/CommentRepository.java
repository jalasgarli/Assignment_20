package org.abbtech.practice.Repository;

import org.abbtech.practice.Entity.Comment;
import org.abbtech.practice.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);
}
