package kr.jonghyun.noticeboard.domain.noticeboard.service;

import kr.jonghyun.noticeboard.domain.noticeboard.dto.InteractionBoardCommentResponseDto;
import kr.jonghyun.noticeboard.domain.noticeboard.entity.InteractionBoard;

import java.util.List;

public interface InteractionBoardCommentService {

    List<InteractionBoardCommentResponseDto> findComments(InteractionBoard interactionBoard);
    int countComments(InteractionBoard interactionBoard);

}
