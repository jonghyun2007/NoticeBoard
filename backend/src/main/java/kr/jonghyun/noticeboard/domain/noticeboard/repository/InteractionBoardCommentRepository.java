package kr.jonghyun.noticeboard.domain.noticeboard.repository;

import kr.jonghyun.noticeboard.domain.noticeboard.entity.InteractionBoard;
import kr.jonghyun.noticeboard.domain.noticeboard.entity.InteractionBoardComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InteractionBoardCommentRepository extends JpaRepository<InteractionBoardComment, Long> {

    List<InteractionBoardComment> findAllByInteractionBoard(InteractionBoard interactionBoard);
    int countByInteractionBoard(InteractionBoard interactionBoard);

}
