package ru.ifmo.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.cs.domain.CommentOnTvSeries;

import java.sql.Timestamp;

/**
 * Created by Богдана on 12.11.2017.
 */

public interface CommentTVRepo extends JpaRepository<CommentOnTvSeries, Integer> {



    @Modifying
    @Transactional
    @Query("update CommentOnTvSeries set content =:content, dateAdd=:date where id=:id")
    void updateComment(@Param("content") String content, @Param("date") Timestamp stamp, @Param("id") int id );
    @Modifying
    @Transactional
    @Query("delete from CommentOnTvSeries where id=:id")
    void remove(@Param("id") int id );
}
