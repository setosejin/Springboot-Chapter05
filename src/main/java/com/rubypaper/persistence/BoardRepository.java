package com.rubypaper.persistence;

import com.rubypaper.domain.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends CrudRepository<Board, Long> {
    List<Board> findByTitle(String searchKeyword);
    List<Board> findByContentContaining(String searchKeyword);
    List<Board> findByTitleContainingOrContentContaining(String title, String content);
    List<Board> findByTitleContainingOrderBySeqDesc(String searchKeyword);
//    List<Board> findByTitleContaining(String searchKeyword, Pageable paging);
    Page<Board> findByTitleContaining(String searchKeyword, Pageable paging);

    // 위치 기반 파라미터 사용
    @Query("select b from Board b where b.title like %?1% order by b.seq desc")
    List<Board> queryAnnotationTest1(String searchKeyword);

    // 이름 기반 파라미터 사용
    @Query("SELECT b FROM Board b " + "WHERE b.title like %:searchKeyword%  " + "ORDER BY b.seq DESC")
    List<Board> queryAnnotationTest2(@Param("searchKeyword") String searchKeyword);

    @Query(value = "select seq, title, writer, create_date " + "from board where title like '%'||?1||'%' " + "order by seq desc", nativeQuery = true)
    List<Object[]> queryAnnotationTest3(String searchKeyword);
}
