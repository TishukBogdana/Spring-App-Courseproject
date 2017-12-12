package ru.ifmo.cs.services;



import ru.ifmo.cs.domain.Human;

import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface HumanService {

    List<Human> findByLogin(String login);
    List<Human> findByPresent(boolean present);

    Iterable<Human> findAll();

    void save(Human human);
    Human findOne(int id);
    void removeByLogin(String login);
    void updateHuman( String login, String passw, String prevLog);
    void update( boolean pres);
}
