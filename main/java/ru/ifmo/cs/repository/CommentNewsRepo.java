package ru.ifmo.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.cs.domain.CommentOnNews;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.domain.News;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */
@Component
public interface CommentNewsRepo extends JpaRepository<CommentOnNews, Integer> {
    List<CommentOnNews> findByAuthor(Human author);
    List<CommentOnNews> findByNews(News news);
    @Modifying
    @Transactional
    @Query("delete from CommentOnNews  com where com.news =?1")
 void removeByNews(News news);
    @Modifying
    @Transactional
    @Query("delete from CommentOnNews com where com.author = ?1")
     void removeByAuthor(Human author);
    @Modifying
    @Transactional
    @Query("update CommentOnNews set content =:content, dateAdd=:date where id=:id")
    void updateComment(@Param("content") String content, @Param("date") Timestamp stamp, @Param("id") int id );
}
