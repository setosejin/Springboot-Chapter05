package com.rubypaper;

import com.rubypaper.domain.Board;
import com.rubypaper.persistence.BoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class QueryAnnotationTest {
    @Autowired
    private BoardRepository boardRepo;
    /*
    @Test
    public void testQueryAnnotationTest1() {
        List<Board> boardList = boardRepo.queryAnnotationTest1("테스트 제목 10");
        System.out.println("검색 결과");
        for (Board board : boardList) {
            System.out.println("---> " + board.toString());
        }
    }
    */
    /*

    @Test
    public void testQueryAnnotationTest2() {
        List<Object[]> boardList = boardRepo.queryAnnotationTest2("테스트 제목 10");
        System.out.println("검색 결과");
        for (Object[] row : boardList) {
            System.out.println("---> " + Arrays.toString(row));
        }
    }
    */

    @Test
    public void testQueryAnnotationTest3() {
        List<Object[]> boardList = boardRepo.queryAnnotationTest3("테스트 제목 10");
        System.out.println("검색 결과");
        for (Object[] row : boardList) {
            System.out.println("---> " + Arrays.toString(row));
        }
    }
}
