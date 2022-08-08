package com.postEngine.domain.service;

import com.postEngine.domain.dto.PostDto;
import com.postEngine.domain.mappers.PostDTOMapper;
import com.postEngine.domain.model.Comment;
import com.postEngine.domain.model.Post;
import com.postEngine.repository.CommentRepository;
import com.postEngine.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PostService implements  PostServiceInterface {


    private PostRepository postRepository;

    private CommentRepository commentRepository;

    private PostDTOMapper postDTOMapper;


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

    public void updatePost(Post post) {
        Post postToUpdate = postRepository.findById(post.getId()).get();
        postToUpdate.setAll(postToUpdate.getId(),
                postToUpdate.getTitle(),
                postToUpdate.getContent(),
                postToUpdate.getNumberOfLikes(),
                postToUpdate.getComments(),
                postToUpdate.getUserLikes());
    }
    @Override
    public void deletePost(Post post){
        Post postToDelete = postRepository.findById(post.getId()).get();
        if(postToDelete.getComments().size() >= 0){
            postToDelete.getComments().forEach(comment->
                    commentRepository.deleteById(comment.getId()));
        }
        postRepository.deleteById(post.getId());
    }

    @Override
    public void deleteComment(Comment comment){
        comment.commentSelfDestruct();
    }

    @Override
    public List<PostDto> findAllPosts() {
        return postRepository.findAll().stream()
                .map(postDTOMapper::postToDto).toList();
    }


    public List<Comment> findAllComments(Post post) {
        Post postToRetrieve = postRepository.findById(post.getId()).get();
        return postToRetrieve.getComments();
    }

}

