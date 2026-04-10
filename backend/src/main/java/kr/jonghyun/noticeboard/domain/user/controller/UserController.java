package kr.jonghyun.noticeboard.domain.user.controller;

import jakarta.servlet.http.HttpServletResponse;
import kr.jonghyun.noticeboard.domain.user.dto.UserRequestDto;
import kr.jonghyun.noticeboard.domain.user.dto.UserResponseDto;
import kr.jonghyun.noticeboard.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<UserResponseDto> register(@RequestBody UserRequestDto requestDto) {
        return ResponseEntity.ok(userService.register(requestDto));
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> login(@RequestBody UserRequestDto requestDto, HttpServletResponse response) {
        userService.login(requestDto, response);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> findUser(@PathVariable Long id) {
        return ResponseEntity.ok(userService.findUser(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/me")
    public ResponseEntity<UserResponseDto> me(@CookieValue(value = "token", required = false) String token) {
        if (token == null) return ResponseEntity.status(401).build();
        return ResponseEntity.ok(userService.me(token));
    }

    @PostMapping("/logout")
    public ResponseEntity<Void> logout(HttpServletResponse response) {
        userService.logout(response);
        return ResponseEntity.ok().build();
    }
}