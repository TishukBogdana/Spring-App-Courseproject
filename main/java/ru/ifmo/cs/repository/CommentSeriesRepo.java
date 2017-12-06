package ru.ifmo.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.cs.domain.CommentOnSeries;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.domain.Series;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */

public interface CommentSeriesRepo extends JpaRepository<CommentOnSeries, Integer> {
    List<CommentOnSeries> findByAuthor(Human author);
    List<CommentOnSeries> findBySeries(Series series);
    @Modifying
    @Transactional
    @Query("delete from CommentOnSeries  com where com.series =?1")
    void removeBySeries(Series series);
    @Modifying
    @Transactional
    @Query("delete from CommentOnArticle  com where com.author =?1")
     void removeByAuthor(Human author);
    @Modifying
    @Transactional
    @Query("update CommentOnSeries set content =:content, dateAdd=:date where id=:id")
    void updateComment(@Param("content") String content, @Param("date") Timestamp stamp, @Param("id") int id );
}
