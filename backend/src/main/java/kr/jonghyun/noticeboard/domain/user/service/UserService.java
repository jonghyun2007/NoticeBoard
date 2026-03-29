package kr.jonghyun.noticeboard.domain.user.service;

import kr.jonghyun.noticeboard.domain.user.dto.UserRequestDto;
import kr.jonghyun.noticeboard.domain.user.dto.UserResponseDto;

public interface UserService {

    UserResponseDto register(UserRequestDto requestDto);
    UserResponseDto login(UserRequestDto requestDto);
    UserResponseDto findUser(Long id);
    void deleteUser(Long id);

}
