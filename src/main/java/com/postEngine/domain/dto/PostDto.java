package com.postEngine.domain.dto;

import com.postEngine.domain.model.Comment;
import com.postEngine.domain.model.UserLike;

import java.util.List;

public class PostDto{

    private Integer id;
    private String title;
    private String content;
    private  Integer number_of_likes;
    private List<UserLike> user_likes;
    private List<Comment> comments;


}
