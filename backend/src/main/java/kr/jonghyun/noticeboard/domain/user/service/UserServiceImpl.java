package kr.jonghyun.noticeboard.domain.user.service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import kr.jonghyun.noticeboard.domain.user.dto.UserRequestDto;
import kr.jonghyun.noticeboard.domain.user.dto.UserResponseDto;
import kr.jonghyun.noticeboard.domain.user.entity.User;
import kr.jonghyun.noticeboard.domain.user.repository.UserRepository;
import kr.jonghyun.noticeboard.global.config.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final JwtUtil jwtUtil;

    @Override
    @Transactional
    public UserResponseDto register(UserRequestDto requestDto) {
        if (userRepository.existsByEmail(requestDto.getEmail())) {
            throw new IllegalArgumentException("이미 존재하는 이메일입니다.");
        }
        if (userRepository.existsByIdentifier(requestDto.getIdentifier())) {
            throw new IllegalArgumentException("이미 존재하는 아이디입니다.");
        }

        User user = requestDto.toEntity();
        userRepository.save(user);
        return UserResponseDto.from(user);
    }

    @Override
    public void login(UserRequestDto requestDto, HttpServletResponse response) {
        User user = userRepository.findByIdentifier(requestDto.getIdentifier())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        if (!user.getPassword().equals(requestDto.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        String token = jwtUtil.generateToken(user.getIdentifier());

        Cookie cookie = new Cookie("token", token);
        cookie.setHttpOnly(true);
        //TODO 배포에서는 true로 변경 (sending https)
        cookie.setSecure(false);
        cookie.setPath("/");
        cookie.setMaxAge(60 * 60 * 1);
        response.addCookie(cookie);
    }

    @Override
    public UserResponseDto findUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));
        return UserResponseDto.from(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new IllegalArgumentException("존재하지 않는 유저입니다.");
        }
        userRepository.deleteById(id);
    }
}
