package org.abbtech.practice.Service;

import org.abbtech.practice.DTO.PostDTO;
import org.abbtech.practice.Entity.Post;
import org.abbtech.practice.Entity.User;
import org.abbtech.practice.Repository.PostRepository;
import org.abbtech.practice.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository, PostRepository postRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

//
//    public Post addPost(long userId, PostDTO postDTO) {
//        User user = userRepository.findById(userId).orElse(null);
//        if(user == null) {
//            throw new RuntimeException("User not found");
//        }
//
//        Post post = new Post();
//        post.setTitle(postDTO.getTitle());
//        post.setContent(postDTO.getContent());
//        post.setUser(user);
//        post.setCreatedDate(LocalDate.now());
//
//        return postRepository.save(post);
//    }


}
