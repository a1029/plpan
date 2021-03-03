package com.example.plpan.service;

import com.example.plpan.dto.BoardDTO;
import com.example.plpan.dto.PageRequestDTO;
import com.example.plpan.dto.PageResultDTO;
import com.example.plpan.entity.Board;

import java.util.List;

public interface BoardService {

    Long register(BoardDTO dto);

    PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);

    BoardDTO get(Long bno);

    void modify(BoardDTO boardDTO);

    void remove(Long bno);

    default Board dtoToEntity(BoardDTO dto){

        Board board = Board.builder()
                .bno(dto.getBno())
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .build();

        return board;
    }

    default BoardDTO entityToDto(Board board, Long replyCount){

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(board.getBno())
                .title(board.getTitle())
                .content(board.getContent())
                .regDate(board.getRegDate())
                .modDate(board.getModDate())
                .writer(board.getWriter())
                .replyCnt(replyCount.intValue())
                .build();

        return boardDTO;
    }


}
