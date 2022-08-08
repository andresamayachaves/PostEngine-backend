package com.postEngine.domain.mappers;

import com.postEngine.domain.dto.CommentDto;
import com.postEngine.domain.dto.UserLikeDto;
import com.postEngine.domain.model.Comment;
import com.postEngine.domain.model.UserLike;
import org.springframework.stereotype.Component;

@Component
public class UserLikeDTOMapper {

    public static UserLikeDto userLikeToDto(UserLike userLike) {
        UserLikeDto userLikeDto = new UserLikeDto();

        userLikeDto.setId(userLike.getId());
        userLikeDto.setUserName(userLike.getUserName());
        userLikeDto.setDni(userLike.getDni());

        return userLikeDto;
    }


    public static UserLike dtoToUserLike(UserLikeDto userLikeDto) {
        UserLike userLike = new UserLike();

        userLike.setId(userLikeDto.getId());
        userLike.setUserName(userLikeDto.getUserName());
        userLike.setDni(userLikeDto.getDni());

        return userLike;
    }
}
