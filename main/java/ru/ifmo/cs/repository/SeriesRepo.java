package ru.ifmo.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.cs.domain.Series;

import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */

public interface SeriesRepo extends JpaRepository<Series, Integer> {
    List<Series> findByName(String name);
    @Modifying
    @Transactional
    @Query("delete from Series s where s.name =?1")
    void removeByName(String name);
    @Modifying
    @Transactional
    @Query("update Series  set name = :name, plot =:descr where name =:prevName")
    void updateSeries(@Param("name") String name, @Param("descr") String descr, @Param("prevName") String prevName );
}
