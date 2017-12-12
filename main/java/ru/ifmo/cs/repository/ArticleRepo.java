package ru.ifmo.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.cs.domain.Article;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 11.11.2017.
 */

public interface ArticleRepo extends JpaRepository<Article, Integer> {
    @Query("select a from Article a where upper(a.name)like upper(:name) and a.moderated= :moder ")
    List<Article> gtbyname(@Param("name") String name, @Param("moder") boolean mod);
    List<Article> findByDateAddIsAfterAndModerated(Timestamp date,boolean mod);
    List<Article> findByDateAddIsBefore(Timestamp date);
    List<Article> findByModerated(boolean moderated);
    @Modifying
    @Transactional
    @Query(value = "delete from Article a where a.idArticle=?1")
    void remove(int id);

   @Modifying
    @Transactional
    @Query("UPDATE Article  SET  moderated = :moder,  dateAdd=:timestamp where idArticle= :id")
    void update(@Param("id") int id, @Param("moder") boolean moder ,@Param("timestamp") Timestamp timestamp);
}

