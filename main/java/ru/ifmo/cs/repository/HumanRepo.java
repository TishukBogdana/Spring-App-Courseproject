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
    List<Human> findByName(String name);
    List<Human>  findBySurname(String sirname);
    List<Human> findByLogin(String login);
    List<Human> findByNameAndSurname(String name, String sirname);
    @Modifying
    @Transactional
    @Query("delete from Human  human where human.login =?1")
    void removeByLogin(String login);
    @Modifying
    @Transactional
    @Query(" update Human set name=:name, surname=:surname, login=:login, password=:password where login=:prevLog")
    void updateHuman(@Param("name") String name, @Param("surname") String surname, @Param("login") String login, @Param("password") String passw, @Param("prevLog") String prevLOg);
}
