package com.postEngine.domain.dto;

import com.postEngine.domain.model.UserLike;

import java.util.List;

public class CommentDto {
    private Integer id;
    private String content;
    private Integer numberOfLikes;
    private List<UserLikeDto> usersLikes;

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

    public Integer getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(Integer numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public List<UserLikeDto> getUsersLikes() {
        return usersLikes;
    }

    public void setUsersLikes(List<UserLikeDto> usersLikes) {
        this.usersLikes = usersLikes;
    }
}
