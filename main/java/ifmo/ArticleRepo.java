package ifmo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 11.11.2017.
 */

public interface ArticleRepo extends JpaRepository<Article, Integer> {
    List<Article> findByName(String name);
    List<Article> findByAuthor(Human author);
    List<Article> findByNameAndAuthor(String name, Human author);
    List<Article> findByDateAddIsAfter(Timestamp date);
    List<Article> findByDateAddIsBefore(Timestamp date);
    @Modifying
    @Transactional
    @Query(value = "delete from Article a where a.name=?1")
    void removeByName(String name);
    @Modifying
    @Transactional
    @Query(value = "delete from Article a where a.author=?1")
    void removeByAuthor(Human author);
   @Modifying
    @Transactional
    @Query("UPDATE Article  SET  name = :name, body=:body, dateAdd=:timestamp where name= :prevname and author =:author")
    void updateNameAndBody(@Param("prevname") String prev,@Param("author") Human author, @Param("name") String name, @Param("body") String body,@Param("timestamp") Timestamp timestamp);
}

