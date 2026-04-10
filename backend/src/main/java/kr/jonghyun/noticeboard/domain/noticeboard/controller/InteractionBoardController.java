package kr.jonghyun.noticeboard.domain.noticeboard.controller;

import kr.jonghyun.noticeboard.domain.noticeboard.dto.InteractionBoardDetailResponseDto;
import kr.jonghyun.noticeboard.domain.noticeboard.dto.InteractionBoardResponseDto;
import kr.jonghyun.noticeboard.domain.noticeboard.service.InteractionBoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/boards")
public class InteractionBoardController {

    private final InteractionBoardService interactionBoardService;

    @GetMapping
    public ResponseEntity<List<InteractionBoardResponseDto>> findAll() {
        return ResponseEntity.ok(interactionBoardService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<InteractionBoardDetailResponseDto> findBoard(@PathVariable Long id) {
        return ResponseEntity.ok(interactionBoardService.findBoard(id));
    }

}