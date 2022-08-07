package com.postEngine.domain.model;

import com.postEngine.domain.service.PostService;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity(name="Post")
@Table(name = "post")
@Data
public class Post {

    PostService postService = new PostService();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postID", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "content", nullable = false, length = 45)
    private String content;

    @Column(name = "number_of_likes", nullable = false, length = 45)
    private Integer numberOfLikes;

    @ManyToMany
    private List<UserLike> userLikes = new ArrayList<>();

    //@OneToMany(mappedBy =  "post_id_post")

    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private static List<Comment> comments = new ArrayList<>();

    public void deleteComment(Integer targetCommentId) {
        comments.remove(targetCommentId);
        postService.deleteComment(comments.get(targetCommentId));
    }
    //Getters and setters
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

    public void setNumberOfLikes(Integer numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setAll(Integer newId, String newTitle,
                       String newContent, Integer newNumberOfLikes,
                       List<UserLike> newListUserLikes){
        setId(newId);
        setTitle(newTitle);
        setContent(newContent);
        setNumberOfLikes(newNumberOfLikes);
    }


    public static void addComment(Comment comment) {
        comments.add(comment);
    }
}