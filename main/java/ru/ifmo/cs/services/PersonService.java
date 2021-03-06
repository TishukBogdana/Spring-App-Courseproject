package ru.ifmo.cs.services;

import ru.ifmo.cs.domain.Person;

import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface PersonService {
    List<Person> findByNameAndSurname(String name, String surname);
    void removeByNameAndSirname(String name, String Sirname);
    Iterable<Person> findAll();
    Person findOne(int id);
    void delete(Person person);
    void save(Person person);
    void updatePerson(String name, String surname,String descr, String prevName, String prevSurname);
}
