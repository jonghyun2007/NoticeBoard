package kr.jonghyun.noticeboard.domain.noticeboard.repository;

import kr.jonghyun.noticeboard.domain.noticeboard.entity.InteractionBoard;
import kr.jonghyun.noticeboard.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InteractionBoardRepository extends JpaRepository<InteractionBoard, Long> {

    List<InteractionBoard> findAllByAuthor(User user);
}
