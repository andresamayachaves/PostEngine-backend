package com.postEngine.domain.controller;

import com.postEngine.domain.model.Comment;
import com.postEngine.domain.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/comment")
public class CommentController {

    private CommentService commentService;

    //Constructor
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("create/comment")
    public List<String> getAllComments(){
        return CommentService.findAllComments();
    }

    @PostMapping
    public Comment createComment(@RequestBody Comment comment){
        return commentService.createComment(comment);
    }

    @PostMapping("update/comment")     // todo, correct annotation?
    public void updatePost(@RequestBody Comment comment){
        commentService.updateComment(comment);
    }

    @DeleteMapping("delete/comment")
    public void deletePost(@RequestBody Comment comment){
        commentService.deleteComment(comment);
    }



}