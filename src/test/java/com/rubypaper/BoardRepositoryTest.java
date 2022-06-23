package com.rubypaper;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
public class BoardRepositoryTest {
    @Autowired
    private BoardRepository boardRepository; // 인터페이스를 Autowired하게 되면 스프링부트의 컨테이너가 구현부를 만들어줍니다.

    @Test
    public void testInsertBoard() {
        Board board = new Board();
        board.setTitle("첫 번째 게시글");
        board.setWriter("테스터");
        board.setContent("잘 등록됩니다");
        board.setCreateDate(new Date());
        board.setCnt(0L);
        boardRepository.save(board);
    }
}
