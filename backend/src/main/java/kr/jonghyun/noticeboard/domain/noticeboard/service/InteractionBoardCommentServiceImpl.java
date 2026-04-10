package kr.jonghyun.noticeboard.domain.noticeboard.service;

import kr.jonghyun.noticeboard.domain.noticeboard.dto.InteractionBoardCommentResponseDto;
import kr.jonghyun.noticeboard.domain.noticeboard.entity.InteractionBoard;
import kr.jonghyun.noticeboard.domain.noticeboard.repository.InteractionBoardCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InteractionBoardCommentServiceImpl implements InteractionBoardCommentService {

    private final InteractionBoardCommentRepository interactionBoardCommentRepository;

    @Override
    public List<InteractionBoardCommentResponseDto> findComments(InteractionBoard interactionBoard) {
        return interactionBoardCommentRepository.findAllByInteractionBoard(interactionBoard).stream().map(InteractionBoardCommentResponseDto::from).toList();
    }

    @Override
    public int countComments(InteractionBoard interactionBoard) {
        return interactionBoardCommentRepository.countByInteractionBoard(interactionBoard);
    }
}
