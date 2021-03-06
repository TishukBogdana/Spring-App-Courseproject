package ru.ifmo.cs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.transaction.annotation.Transactional;
import ru.ifmo.cs.domain.Person;

import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */

public interface PersonRepo extends JpaRepository<Person, Integer> {
    List<Person> findByNameAndSurname(String name, String surname);
    @Modifying
    @Transactional
    @Query("delete from Person person where person.name = ?1 and person.surname =?2")
    void removeByNameAndSirname(String name, String Sirname);
    @Modifying
    @Transactional
    @Query("update Person set name =:name, surname=:surname, description=:descr where  name =:prevName and surname=:prevSurname" )
    void updatePerson(@Param("name") String name, @Param("surname")String surname, @Param("descr") String descr, @Param("prevName") String prevName, @Param("prevSurname") String prevSurname);
}
