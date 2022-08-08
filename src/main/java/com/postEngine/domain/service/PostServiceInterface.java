package com.postEngine.domain.service;

import com.postEngine.domain.dto.PostDto;
import com.postEngine.domain.model.Comment;
import com.postEngine.domain.model.Post;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PostServiceInterface {
    Post createPost(Post post);
    Comment createComment(Comment comment);
    void deleteComment (Comment comment);
    void deletePost(Post post);
    List<PostDto> findAllPosts();
}
