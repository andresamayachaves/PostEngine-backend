package com.postEngine.domain.mappers;

import com.postEngine.domain.dto.CommentDto;
import com.postEngine.domain.dto.CommentDto;
import com.postEngine.domain.model.Comment;
import com.postEngine.domain.model.UserLike;
import org.springframework.stereotype.Component;

@Component
public class CommentDTOMapper {


    public static CommentDto commentToDto(Comment comment) {
        CommentDto commentDto = new CommentDto();
        commentDto.setId(comment.getId());
        commentDto.setContent(comment.getContent());
        commentDto.setNumberOfLikes(comment.getNumberOfLikes());
        commentDto.setUsersLikes(
                comment.getUsersLikes().stream().map(UserLikeDTOMapper::userLikeToDto).toList());

        return commentDto;

    }
    public static Comment dtoToComment(CommentDto commentDto) {
        Comment comment= new Comment();
        comment.setId(commentDto.getId());
        comment.setContent(commentDto.getContent());
        comment.setNumberOfLikes(commentDto.getNumberOfLikes());
        comment.setUsersLikes(
                commentDto.getUsersLikes().stream().map(UserLikeDTOMapper::dtoToUserLike).toList());

        return comment;
    }

}
