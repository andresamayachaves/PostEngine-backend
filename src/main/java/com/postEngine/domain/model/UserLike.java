package com.postEngine.domain.model;

import lombok.Data;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name="UserLike")
@Table(name = "user_like")
@Data
public class UserLike {
    @Id
    @Column(name = "id_user_like", nullable = false)
    private Integer id;

    @Column(name = "user_name", length = 45)
    private String userName;

    @Column(name = "dni", length = 45)
    private String dni;

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



}