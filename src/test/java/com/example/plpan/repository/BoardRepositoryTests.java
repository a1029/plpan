package com.example.plpan.repository;

import com.example.plpan.entity.Board;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class BoardRepositoryTests {

    @Autowired
    private BoardRepository boardRepository;

    @Test
    public void insertBoard(){

        IntStream.rangeClosed(1, 100).forEach(i -> {
            Board board = Board.builder()
                    .title("제목" + "  " + i)
                    .content("내용" + "  " + i)
                    .writer("ㅇㅇ")
                    .build();

            boardRepository.save(board);
        });
    }

}
