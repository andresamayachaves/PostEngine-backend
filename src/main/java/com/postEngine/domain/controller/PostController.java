package com.postEngine.domain.controller;

import com.postEngine.domain.dto.PostDto;
import com.postEngine.domain.model.Post;
import com.postEngine.domain.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/post")
public class PostController {

    @Autowired
    private PostService postService;

    //Constructor
    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

   @GetMapping("get/all/posts")
    public List<PostDto> getAllPosts(){
        return postService.findAllPosts();
    }

    @PostMapping ("create/post")
    public Post createPost(@RequestBody Post post){
        return postService.createPost(post);
    }

    @GetMapping("get/all/comments")
    public List<PostDto> getAllComments(){
        return  postService.findAllPosts() ; // CommentService.findAllComments();
    }

    @PostMapping ("update/post")    // todo, correct annotation?
    public void updatePost(@RequestBody Post post){
        postService.updatePost(post);
    }

    @DeleteMapping("delete/post")
    public void deletePost(@RequestBody Post post){
        postService.deletePost(post);
    }

}
