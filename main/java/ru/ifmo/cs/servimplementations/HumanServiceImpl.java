package ru.ifmo.cs.servimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.repository.HumanRepo;
import ru.ifmo.cs.services.HumanService;

import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */

@Service

public class HumanServiceImpl implements HumanService {
    @Autowired

    private HumanRepo repo;
public     List<Human> findByName(String name){return  repo.findByName(name);}
 public    List<Human>  findBySurname(String sirname){return repo.findBySurname(sirname);}
  public   List<Human> findByLogin(String login){return repo.findByLogin(login);}
    public List<Human> findByNameAndSurname(String name, String sirname){return repo.findByNameAndSurname(name, sirname);}
    public void removeByLogin(String login){repo.removeByLogin(login);}
 public    Iterable<Human> findAll(){return repo.findAll();}
   public void delete(Human human){repo.delete(human);}
public     void save(Human human){repo.save(human);}
public Human findOne(int id){return  repo.findOne(id);}
   public void updateHuman(String name, String surname, String login, String passw, String prevLog){repo.updateHuman(name, surname,login,passw,prevLog);}

}
