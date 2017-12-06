package ru.ifmo.cs.services;

import ru.ifmo.cs.domain.Human;

import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface HumanService {
    List<Human> findByName(String name);
    List<Human>  findBySurname(String sirname);
    List<Human> findByLogin(String login);
    List<Human> findByNameAndSurname(String name, String sirname);
    Iterable<Human> findAll();
    void delete(Human human);
    void save(Human human);
    Human findOne(int id);
    void removeByLogin(String login);
    void updateHuman(String name, String surname, String login, String passw, String prevLog);
}
