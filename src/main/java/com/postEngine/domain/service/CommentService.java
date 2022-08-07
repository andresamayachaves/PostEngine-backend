package com.postEngine.domain.service;

import com.postEngine.domain.model.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {
    public static List<String> findAllComments() {
        return null; //todo
    }

    public static void DeleteComment() {
        //todo
    }

    public List<String> getClassB(){
        return List.of("Back-end", "Running", "in", "Class");
    }

    public Comment createComment(Comment comment) {
        return null; //todo
    }

    public void deleteComment(Comment comment) {
        //todo
    }

    public void updateComment(Comment comment) {
        //todo
    }
}
