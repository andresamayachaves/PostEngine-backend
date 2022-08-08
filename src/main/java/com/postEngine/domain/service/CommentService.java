package com.postEngine.domain.service;

import com.postEngine.domain.dto.CommentDto;
import com.postEngine.domain.mappers.CommentDTOMapper;
import com.postEngine.domain.model.Comment;
import com.postEngine.domain.model.Post;
import com.postEngine.repository.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CommentService {

    private static CommentRepository commentRepo;

    public Comment createComment(CommentDto comment) {
        Comment commentAsEntity = CommentDTOMapper.dtoToComment (comment);
        commentRepo.save(commentAsEntity);
        Post.addComment(commentAsEntity);
        return commentAsEntity;

    }

    public List<Comment>  getAllComments( ) {
        return commentRepo.findAll();
    }
    public void updateComment(CommentDto commentUpdated) {
        Comment targetComment = commentRepo.getReferenceById(commentUpdated.getId());
        targetComment.setContent(commentUpdated.getContent());
        targetComment.setContent(commentUpdated.getContent());
    }
    public static void deleteComment(Comment commentToDelete) {

    }


    public void oneLike(Comment commentLiked, Boolean moreLess){   //True: 1 like more; False: 1 like less
        int decide = 0;
        if(moreLess == false) decide = 1;
        Comment targetComment = commentRepo.getReferenceById(commentLiked.getId());
        targetComment.setNumberOfLikes(commentLiked.getNumberOfLikes()+1*(-1 *decide));
    }

}
