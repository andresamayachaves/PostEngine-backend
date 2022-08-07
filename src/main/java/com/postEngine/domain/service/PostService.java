package com.postEngine.domain.service;

import com.postEngine.domain.model.Comment;
import com.postEngine.domain.model.Post;
import com.postEngine.repository.CommentRepository;
import com.postEngine.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class PostService implements  PostServiceInterface {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CommentRepository commentRepository;


    @Override
    public Post createPost(Post post){
        return postRepository.save(post);
    }

    @Override
    public Comment createComment(Comment comment){
        Post post = postRepository.findById(comment.getFK_post_id()).get();
        post.addComment(comment);
        commentRepository.save(comment);
        postRepository.save(post);
        return comment;
    }

    @Override
    public void deleteComment(Comment comment){
        comment.commentSelfDestruct();
    }

    @Override
    public void deletePost(Post post){
        Post postToDelete = postRepository.findById(post.getId()).get();
        /*if(postToDelete.getComments().size() >= 0){
            postToDelete.getComments().forEach(comment->
                    commentRepository.deleteById(comment.getId()));
        }
        postRepository.deleteById(post.getId());*/
    }

    //@Override
    public List<Post> findAllPosts() {
        return postRepository.findAll();
    }

    public void updatePost(Post post) {
        //todo
    }
}

