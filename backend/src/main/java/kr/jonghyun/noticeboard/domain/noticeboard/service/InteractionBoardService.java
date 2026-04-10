package kr.jonghyun.noticeboard.domain.noticeboard.service;

import kr.jonghyun.noticeboard.domain.noticeboard.dto.InteractionBoardDetailResponseDto;
import kr.jonghyun.noticeboard.domain.noticeboard.dto.InteractionBoardResponseDto;

import java.util.List;

public interface InteractionBoardService {


    List<InteractionBoardResponseDto> findAll();
    InteractionBoardDetailResponseDto findBoard(Long id);

}