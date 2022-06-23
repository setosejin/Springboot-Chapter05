package com.rubypaper;

import com.querydsl.core.BooleanBuilder;
import com.rubypaper.domain.Board;
import com.rubypaper.domain.QBoard;
import com.rubypaper.persistence.DynamicBoardRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@SpringBootTest
public class DynamicQueryTest {
    @Autowired
    private DynamicBoardRepository dynamicBoardRepository;

    @Test
    public void testDynamicQuery(){
        String searchKeyword = "테스트 제목 10";
        String searchCondition = "TITLE";

        BooleanBuilder builder = new BooleanBuilder();
        QBoard qBoard = QBoard.board;

        if(searchCondition.equals("TITLE")){
            builder.and(qBoard.title.like("%"+searchKeyword+"%"));
        } else if(searchCondition.equals("CONTENT")){
            builder.and(qBoard.title.like("%"+searchKeyword+"%"));
        }

        Pageable paging = PageRequest.of(0, 5);
        Page<Board> boardList = dynamicBoardRepository.findAll(builder, paging);
        System.out.println("검색 결과 :\n");
        for(Board board : boardList){
            System.out.println("--->" + board.toString());
        }
    }
}
