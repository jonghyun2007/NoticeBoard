package kr.jonghyun.noticeboard.domain.user.service;

import jakarta.servlet.http.HttpServletResponse;
import kr.jonghyun.noticeboard.domain.user.dto.UserRequestDto;
import kr.jonghyun.noticeboard.domain.user.dto.UserResponseDto;

public interface UserService {

    UserResponseDto register(UserRequestDto requestDto);
    void login(UserRequestDto requestDto, HttpServletResponse response);
    UserResponseDto findUser(Long id);
    void deleteUser(Long id);
    UserResponseDto me(String token);
    void logout(HttpServletResponse response);

}
