package org.abbtech.practice.Service;

import org.abbtech.practice.DTO.CommentDTO;
import org.abbtech.practice.Entity.Comment;
import org.abbtech.practice.Entity.Post;
import org.abbtech.practice.Entity.User;
import org.abbtech.practice.Repository.CommentRepository;
import org.abbtech.practice.Repository.PostRepository;
import org.abbtech.practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository
    , PostRepository postRepository, UserRepository userRepository ) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public Comment addComment(long postId, CommentDTO commentDTO) {
        Post post = postRepository.findById(postId).orElse(null);
        if(post == null) {
            throw new RuntimeException("Post with Id: " + postId + " not found");
        }

        Comment comment = new Comment();
        comment.setCreatedDate(LocalDate.now());
        comment.setPost(post);
        comment.setContent(commentDTO.getContent());

        return commentRepository.save(comment);
    }
}
