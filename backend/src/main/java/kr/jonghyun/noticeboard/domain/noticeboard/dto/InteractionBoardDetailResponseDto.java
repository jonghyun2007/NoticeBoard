package kr.jonghyun.noticeboard.domain.noticeboard.dto;

import kr.jonghyun.noticeboard.domain.noticeboard.entity.InteractionBoard;
import lombok.Value;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class InteractionBoardDetailResponseDto {

    Long id;
    String name;
    String author;
    String contents;
    LocalDateTime createdAt;
    List<InteractionBoardCommentResponseDto> comments;

    public static InteractionBoardDetailResponseDto from(
            InteractionBoard board,
            List<InteractionBoardCommentResponseDto> comments) {
        return new InteractionBoardDetailResponseDto(
                board.getId(),
                board.getName(),
                board.getAuthor().getIdentifier(),
                board.getContents(),
                board.getCreatedAt(),
                comments
        );
    }

}
