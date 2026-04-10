package kr.jonghyun.noticeboard.domain.noticeboard.service;

import kr.jonghyun.noticeboard.domain.noticeboard.dto.InteractionBoardDetailResponseDto;
import kr.jonghyun.noticeboard.domain.noticeboard.dto.InteractionBoardResponseDto;
import kr.jonghyun.noticeboard.domain.noticeboard.entity.InteractionBoard;
import kr.jonghyun.noticeboard.domain.noticeboard.repository.InteractionBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InteractionBoardServiceImpl implements InteractionBoardService {

    private final InteractionBoardRepository interactionBoardRepository;
    private final InteractionBoardCommentService interactionBoardCommentService;

    @Override
    public List<InteractionBoardResponseDto> findAll() {
        return interactionBoardRepository.findAll().stream()
                .map(board -> InteractionBoardResponseDto.from(
                        board,
                        interactionBoardCommentService.countComments(board)))
                .toList();
    }

    @Override
    public InteractionBoardDetailResponseDto findBoard(Long id) {
        InteractionBoard board = interactionBoardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시글입니다."));
        return InteractionBoardDetailResponseDto.from(
                board,
                interactionBoardCommentService.findComments(board));
    }
}
