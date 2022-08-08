package com.postEngine.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name="UserLike")
@Table(name = "user_like")
@Data
@NoArgsConstructor
public class UserLike {
    @Id
    @Column(name = "id_user_like", nullable = false)
    private Integer id;

    @Column(name = "user_name", length = 45)
    private String userName;

    @Column(name = "dni", length = 45)
    private String dni;

    public UserLike(Integer id, String userName, String dni, Set<Comment> comments, Set<Post> posts) {
        this.id = id;
        this.userName = userName;
        this.dni = dni;
        this.comments = comments;
        this.posts = posts;
    }

    @ManyToMany
    @JoinTable(name = "comments_has_user_like",
            joinColumns = @JoinColumn(name = "user_like_id_user_like"),
            inverseJoinColumns = @JoinColumn(name = "comments_id_comments"))
    private Set<Comment> comments = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "user_like_has_post",
            joinColumns = @JoinColumn(name = "user_like_id_user_like"),
            inverseJoinColumns = @JoinColumn(name = "post_id_post"))
    private Set<Post> posts = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Set<Comment> getComments() {
        return comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

    public Set<Post> getPosts() {
        return posts;
    }

    public void setPosts(Set<Post> posts) {
        this.posts = posts;
    }
}