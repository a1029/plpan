package com.example.plpan.repository;

import com.example.plpan.entity.Board;
import com.example.plpan.entity.Reply;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
public class ReplyRepositoryTests {

    @Autowired
    private ReplyRepository replyRepository;

    @Test
    public void testInsert(){

        IntStream.rangeClosed(1, 99).forEach(i -> {

            Reply reply = Reply.builder()
                    .content("댓글1")
                    .replyer("ㅇㅇ")
                    .board(Board.builder().bno((long)i).build())
                    .build();

            Reply reply2 = Reply.builder()
                    .content("댓글2")
                    .replyer("ㅇㅇ")
                    .board(Board.builder().bno((long)i).build())
                    .build();

            replyRepository.save(reply);
            replyRepository.save(reply2);
        });
    }
}
