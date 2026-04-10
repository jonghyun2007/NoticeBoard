package kr.jonghyun.noticeboard.domain.noticeboard.dto;

import kr.jonghyun.noticeboard.domain.noticeboard.entity.InteractionBoardComment;
import lombok.Value;

import java.time.LocalDateTime;

@Value
public class InteractionBoardCommentResponseDto {

    Long id;
    String author;
    String comment;
    LocalDateTime createdAt;

    public static InteractionBoardCommentResponseDto from(InteractionBoardComment comment) {
        return new InteractionBoardCommentResponseDto(
                comment.getIdx(),
                comment.getAuthor().getIdentifier(),
                comment.getComment(),
                comment.getCreatedAt()
        );
    }

}
