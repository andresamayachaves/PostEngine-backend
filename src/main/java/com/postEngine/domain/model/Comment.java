package com.postEngine.domain.model;

import com.postEngine.domain.service.CommentService;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Table(name = "comment")
@Data
@Entity(name="Comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "comment_id", nullable = false)
    private Integer id;

    @Column(name = "content", length = 45)
    private String content;

    @Column(name = "numberOfLikes", length = 45)
    private Integer numberOfLikes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "post_postID", nullable = false)
    private Post postIdPost;

    @ManyToMany
    private List<UserLike> usersLikes = new ArrayList<UserLike>() ;

    public Integer getFK_post_id(){
        return postIdPost.getId();
    }

    public void  commentSelfDestruct(){
        CommentService.deleteComment(this);
    }

//Getters & setters
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

    public void setNumberOfLikes(Integer  numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Post getPostIdPost() {
        return postIdPost;
    }

    public void setPostIdPost(Post postIdPost) {
        this.postIdPost = postIdPost;
    }


    public void setUsersLikes(List<UserLike> usersLikes) {
        this.usersLikes = usersLikes;
    }
    public List<UserLike> getUsersLikes() {
        return usersLikes;
    }
}