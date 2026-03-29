package kr.jonghyun.noticeboard.domain.user.dto;

import kr.jonghyun.noticeboard.domain.user.entity.User;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserRequestDto {
    private String identifier;
    private String email;
    private String password;

    public User toEntity() {
        return User.builder()
                .identifier(identifier)
                .email(email)
                .password(password)
                .build();
    }
}
