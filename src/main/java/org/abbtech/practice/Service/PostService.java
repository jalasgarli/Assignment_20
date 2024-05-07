package org.abbtech.practice.Service;

import org.abbtech.practice.DTO.PostDTO;
import org.abbtech.practice.Entity.Comment;
import org.abbtech.practice.Entity.Post;
import org.abbtech.practice.Entity.User;
import org.abbtech.practice.Repository.CommentRepository;
import org.abbtech.practice.Repository.PostRepository;
import org.abbtech.practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public PostService(PostRepository postRepository, UserRepository userRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.commentRepository = commentRepository;
    }

    public Post addPost(long userId, PostDTO postDTO) {
        User user = userRepository.findById(userId).orElse(null);
        if(user == null) {
            throw new RuntimeException("");
        }
        Post post = new Post();
        post.setUser(user);
        post.setContent(postDTO.getContent());
        post.setCreatedDate(LocalDate.now());
        post.setTitle(postDTO.getTitle());

        return postRepository.save(post);
    }

    // ...
    public Post getPost(long userId, long postId) {
        return new Post();
    }
}
