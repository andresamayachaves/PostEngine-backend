package com.postEngine.domain.dto;

import com.postEngine.domain.model.Comment;
import com.postEngine.domain.model.UserLike;

import java.util.Arrays;
import java.util.List;

public class PostDto{

    private Integer id;
    private String title;
    private String content;
    private  Integer numberOfLikes;
    private List<UserLikeDto> user_likes;
    private List<CommentDto> comments;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
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

    public void setNumber_of_likes(Integer number_of_likes) {
        this.numberOfLikes = number_of_likes;
    }

    public List<UserLikeDto> getUsersLikes() {
        return user_likes;
    }

    public void setUser_likes(List<UserLikeDto> user_likes) {
        this.user_likes = user_likes;
    }

    public List<CommentDto> getComments() {
        return comments;
    }

    public void setComments(List<CommentDto> comments) {
        this.comments = comments;
    }

}
