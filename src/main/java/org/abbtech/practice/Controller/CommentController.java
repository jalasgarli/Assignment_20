package org.abbtech.practice.Controller;

import org.abbtech.practice.DTO.CommentDTO;
import org.abbtech.practice.Entity.Comment;
import org.abbtech.practice.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/addComment/{postId}")
    public ResponseEntity<Comment> addComment(@PathVariable long postId, @RequestBody CommentDTO commentDTO) {
        Comment comment = commentService.addComment(postId, commentDTO);
        return new ResponseEntity<>(comment, HttpStatus.CREATED);
    }
}
