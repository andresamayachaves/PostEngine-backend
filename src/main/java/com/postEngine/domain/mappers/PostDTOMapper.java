package com.postEngine.domain.mappers;

import com.postEngine.domain.dto.PostDto;
import com.postEngine.domain.model.Post;
import org.springframework.stereotype.Component;

@Component
public class PostDTOMapper {

    public PostDto postToDto(Post post) {
        PostDto postDto = new PostDto();
        postDto.setId(post.getId());
        postDto.setTitle(post.getTitle());
        postDto.setContent(post.getContent());
        postDto.setNumber_of_likes(post.getNumberOfLikes());
        postDto.setComments(
                post.getComments().stream().map(CommentDTOMapper::commentToDto).toList());
        postDto.setUser_likes(
                post.getUserLikes().stream().map(UserLikeDTOMapper::userLikeToDto).toList());

        return postDto;
    }

    public Post dtoToPost(PostDto postDto){
        Post post = new Post();
        post.setId(postDto.getId());
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setNumberOfLikes(postDto.getNumberOfLikes());
        post.setComments(
                postDto.getComments().stream().map(CommentDTOMapper::dtoToComment).toList());
       post.setUserLikes(
                postDto.getUsersLikes().stream().map(UserLikeDTOMapper::dtoToUserLike).toList());

        return post;
    }

}
