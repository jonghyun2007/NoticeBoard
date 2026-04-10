package kr.jonghyun.noticeboard.domain.user.repository;

import kr.jonghyun.noticeboard.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);
    Optional<User> findByIdentifier(String identifier);
    boolean existsByEmail(String email);
    boolean existsByIdentifier(String identifier);

}
