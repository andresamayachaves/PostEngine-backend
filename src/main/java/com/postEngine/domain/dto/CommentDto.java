package com.postEngine.domain.dto;

import com.postEngine.domain.model.UserLike;

import java.util.List;

public class CommentDto {
    private Integer id;
    private String content;
    private Integer number_of_likes;
    private List<UserLike> users_likes;
}
