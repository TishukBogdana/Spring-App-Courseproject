package ru.ifmo.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.cs.domain.CommentOnTvSeries;
import ru.ifmo.cs.domain.Human;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */

public interface CommentTVRepo extends JpaRepository<CommentOnTvSeries, Integer> {

    List<CommentOnTvSeries> findByAuthor(Human author);

    @Modifying
    @Transactional
    @Query("delete from CommentOnTvSeries  com where com.author =?1")
   void removeByAuthor(Human author);
    @Modifying
    @Transactional
    @Query("update CommentOnTvSeries set content =:content, dateAdd=:date where id=:id")
    void updateComment(@Param("content") String content, @Param("date") Timestamp stamp, @Param("id") int id );
}
