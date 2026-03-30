package kr.jonghyun.noticeboard.domain.user.dto;

import kr.jonghyun.noticeboard.domain.user.entity.User;
import lombok.Value;

@Value
public class UserResponseDto {
    Long id;
    String identifier;
    String email;

    public static UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getIdentifier(), user.getEmail());
    }
}
