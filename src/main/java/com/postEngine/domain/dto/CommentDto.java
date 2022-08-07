package com.postEngine.domain.dto;

import com.postEngine.domain.model.UserLike;

import java.util.List;

public class CommentDto {
    private Integer id;
    private String content;
    private Integer number_of_likes;
    private List<UserLike> users_likes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getNumber_of_likes() {
        return number_of_likes;
    }

    public void setNumber_of_likes(Integer number_of_likes) {
        this.number_of_likes = number_of_likes;
    }

    public List<UserLike> getUsers_likes() {
        return users_likes;
    }

    public void setUsers_likes(List<UserLike> users_likes) {
        this.users_likes = users_likes;
    }
}
