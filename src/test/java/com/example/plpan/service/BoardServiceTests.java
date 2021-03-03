package com.example.plpan.service;


import com.example.plpan.dto.BoardDTO;
import com.example.plpan.dto.PageRequestDTO;
import com.example.plpan.dto.PageResultDTO;
import com.example.plpan.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardServiceTests {

    @Autowired
    private BoardService boardService;

    @Test
    public void testRegister(){

        BoardDTO dto = BoardDTO.builder()
                .title("서비스 테스트 제목")
                .content("서비스 테스트 내용")
                .writer("ㅇㅇ")
                .build();

        Long bno = boardService.register(dto);
    }

    @Test
    public void testGetList(){

        PageRequestDTO pageRequestDTO = new PageRequestDTO();
        PageResultDTO<BoardDTO, Object[]> result = boardService.getList(pageRequestDTO);

        for (BoardDTO boardDTO : result.getDtoList()){
            System.out.println(boardDTO);
        }
    }

    @Test
    public void testGet(){

        BoardDTO boardDTO = boardService.get(101L);

        System.out.println(boardDTO);
    }

    @Test
    public void testRemove(){

        boardService.remove(1L);
    }

    @Test
    public void testModify(){

        BoardDTO boardDTO = BoardDTO.builder()
                .bno(2L)
                .title("수정 서비스 테스트")
                .content("수정 서비스 테스트")
                .build();

        boardService.modify(boardDTO);
    }
}
