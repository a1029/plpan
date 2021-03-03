package com.example.plpan.repository;

import com.example.plpan.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("SELECT b, r FROM Board b LEFT JOIN Reply r ON r.board = b where b.bno=:bno")
    List<Object[]> getBoardWithReply(@Param("bno") Long bno);

    @Query("SELECT b, count(r) FROM Board b LEFT JOIN Reply r ON r.board = b where b.bno=:bno")
    Object getBoardByBno(@Param("bno") Long bno);

    @Query(
            value="SELECT b, count(r) from Board b LEFT JOIN Reply r ON r.board = b GROUP BY b",
            countQuery = "SELECT count(b) from Board b")
    Page<Object[]> getBoardWithReplyCount(Pageable pageable);


}
