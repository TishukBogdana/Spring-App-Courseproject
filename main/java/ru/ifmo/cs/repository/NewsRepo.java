package ru.ifmo.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.cs.domain.News;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */

public interface NewsRepo extends JpaRepository<News, Integer> {
    @Query("select n from News n where upper(n.name)like upper(:name) and n.moderated= :moder ")

    List<News> findByNameAndModerated(@Param("name") String name, @Param("moder") boolean mod);
    List<News> findByDateAddIsAfterAndModerated(Timestamp date, boolean mod);
    List<News> findByDateAddBeforeAndModerated(Timestamp date, boolean mod);
    List<News> findByModerated(boolean moderated);

    @Modifying
    @Transactional
    @Query("delete from News n where n.dateAdd< ?1")
    void removeIfDateIsBefore(Timestamp date);
    @Modifying
    @Transactional
    @Query("delete from News n where n.idNews =?1 ")
    void remove(int id);
    @Modifying
    @Transactional
    @Query("UPDATE News  SET  moderated = :moder,  dateAdd=:timestamp where idNews= :id")
    void update(@Param("id") int id, @Param("moder") boolean moder ,@Param("timestamp") Timestamp timestamp);
}
