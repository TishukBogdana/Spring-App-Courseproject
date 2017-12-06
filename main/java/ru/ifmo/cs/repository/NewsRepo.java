package ru.ifmo.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.cs.domain.News;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */

public interface NewsRepo extends JpaRepository<News, Integer> {

    List<News> findByName(String name);
    List<News> findByDateAddIsAfter(Timestamp date);
    List<News> findByDateAddBefore(Timestamp date);
    List<News> findByModerated(boolean moderated);

    @Modifying
    @Transactional
    @Query("delete from News n where n.dateAdd< ?1")
    void removeIfDateIsBefore(Timestamp date);
    @Modifying
    @Transactional
    @Query("delete from News n where n.name =?1 ")
    void removeByName(String name);
}
