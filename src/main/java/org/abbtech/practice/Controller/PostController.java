package org.abbtech.practice.Controller;

import org.abbtech.practice.DTO.PostDTO;
import org.abbtech.practice.Entity.Post;
import org.abbtech.practice.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/{userId}/addPost")
    public ResponseEntity<Post> addPost(@PathVariable long userId, @RequestBody PostDTO postDTO) {
        Post newPost = postService.addPost(userId, postDTO);
        return new ResponseEntity<>(newPost, HttpStatus.CREATED);
    }

//    @GetMapping("/{userId}/{postId}")
//    public ResponseEntity<List<Post>> getPost(@PathVariable long userId, @PathVariable long postId) {
//        List<Post> posts = postService.getPost(userId, postId);
//        return new ResponseEntity<>(posts, HttpStatus.OK);
//    }
}
