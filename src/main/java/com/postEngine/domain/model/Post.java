package com.postEngine.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name="Post")
@Table(name = "post")
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "postID", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 45)
    private String title;

    @Column(name = "content", nullable = false, length = 45)
    private String content;

    @Column(name = "number_of_likes", nullable = false, length = 45)
    private String numberOfLikes;

    @ManyToMany
    private Set<UserLike> userLikes = new LinkedHashSet<>();

    //@OneToMany(mappedBy =  "post_id_post")
    //jjjjjjjjjjjjjjj


    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private Set<Comment> comments = new LinkedHashSet<>();


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

    public String getNumberOfLikes() {
        return numberOfLikes;
    }

    public void setNumberOfLikes(String numberOfLikes) {
        this.numberOfLikes = numberOfLikes;
    }

    public Collection<Object> getComments() {
        return null; //toDo method
    }

    public void addComment(Comment comment) {
        //todo
    }
}