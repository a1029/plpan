package com.example.plpan.repository;

import com.example.plpan.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;


@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void testInsert(){

        IntStream.rangeClosed(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("제목" + "  " + i)
                    .content("내용" + "  " + i)
                    .writer("ㅇㅇ")
                    .build();

            boardRepository.save(board);
        });
    }

    @Test
    public void testDelete(){

        boardRepository.deleteById(100L);
    }

    @Test
    public void testModify(){

        Optional<Board> optional = boardRepository.findById(99L);

        if(optional.isPresent()){
            Board board = optional.get();

            board.changeTitle("수정된 제목 99");
            board.changeContent("수정된 내용 99");

            boardRepository.save(board);
        }
    }

    @Test
    public void testRead(){

        Optional<Board> optional = boardRepository.findById(99L);

        if(optional.isPresent()){
            Board board = optional.get();

            System.out.println(board);
        }
    }

    @Test
    public void testGetBoardWithReply(){

        List<Object[]> result = boardRepository.getBoardWithReply(1L);

        for(Object[] arr : result) {
            System.out.println(Arrays.toString(arr));
        }
    }

    @Test
    public void testGetList(){

        Pageable pageable = PageRequest.of(1, 10, Sort.by("bno").descending());
        Page<Object[]> result = boardRepository.getBoardWithReplyCount(pageable);

        result.get().forEach(row -> {

            System.out.println(Arrays.toString(row));
        });
    }
}
