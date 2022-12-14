package com.postEngine.domain.controller;

import com.postEngine.domain.dto.CommentDto;
import com.postEngine.domain.mappers.CommentDTOMapper;
import com.postEngine.domain.model.Comment;
import com.postEngine.domain.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping(path = "api/comment")
public class CommentController {

    private CommentService commentService;

    //Constructor
    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }


    @PostMapping("create/comment")
    public void createComment(@RequestBody CommentDto comment){
        commentService.createComment(comment);
    }

    @GetMapping("get/all/comments")
    public List<Comment> getAllComments(){
        return commentService.getAllComments();
    }

    @PutMapping("edit/comment")     // todo, correct annotation?
    public void updatePost(@RequestBody CommentDto comment){
        commentService.updateComment(comment);
    }

    @DeleteMapping("delete/comment")
    public void deletePost(@RequestBody CommentDto comment){
        commentService.deleteComment(CommentDTOMapper.dtoToComment(comment));
    }



}