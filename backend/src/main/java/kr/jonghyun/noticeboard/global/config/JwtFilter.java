package kr.jonghyun.noticeboard.global.config;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Optional<String> tokenOptional = extractToken(request);
        if (tokenOptional.isPresent()) {
            String token = tokenOptional.get();
            if (jwtUtil.validateToken(token)) {
                String identifier = jwtUtil.extractIdentifier(token);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(identifier, null, List.of());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }
        filterChain.doFilter(request, response);
    }

    private Optional<String> extractToken(HttpServletRequest request) {
        Optional<String> cookieOptional = Optional.empty();
        if (request.getCookies() == null) return cookieOptional;
        for (Cookie cookie : request.getCookies()) {
            if ("token".equals(cookie.getName())) return Optional.of(cookie.getValue());
        }
        return cookieOptional;
    }

}
