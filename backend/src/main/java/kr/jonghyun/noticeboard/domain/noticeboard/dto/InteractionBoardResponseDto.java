package kr.jonghyun.noticeboard.domain.noticeboard.dto;

import kr.jonghyun.noticeboard.domain.noticeboard.entity.InteractionBoard;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class InteractionBoardResponseDto {

    Long id;
    String name;
    String author;
    String contents;
    LocalDateTime createdAt;
    int commentCount;

    public static InteractionBoardResponseDto from(InteractionBoard board, int commentCount) {
        return new InteractionBoardResponseDto(
                board.getId(),
                board.getName(),
                board.getAuthor().getIdentifier(),
                board.getContents(),
                board.getCreatedAt(),
                commentCount
        );
    }
}