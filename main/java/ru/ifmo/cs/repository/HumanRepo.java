package ru.ifmo.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.cs.domain.Human;

import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */

public interface HumanRepo extends JpaRepository<Human, Integer> {

    List<Human> findByLogin(String login);
  List<Human> findByPresent(boolean present);
    @Modifying
    @Transactional
    @Query("delete from Human  human where human.login =?1")
    void removeByLogin(String login);
    @Modifying
    @Transactional
    @Query(" update Human set  login=:login, password=:password where login=:prevLog")
    void updateHuman( @Param("login") String login, @Param("password") String passw, @Param("prevLog") String prevLOg);
    @Modifying
    @Transactional
    @Query(" update Human set  present=:present ")
    void update( @Param("present") boolean pres);

}
