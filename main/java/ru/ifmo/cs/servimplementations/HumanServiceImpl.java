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
  public   List<Human> findByLogin(String login){return repo.findByLogin(login);}
  public   List<Human> findByPresent(boolean present){return repo.findByPresent(present);}
public  void update(  boolean pres){repo.update(pres);}
    public void removeByLogin(String login){repo.removeByLogin(login);}
 public    Iterable<Human> findAll(){return repo.findAll();}

public     void save(Human human){repo.save(human);}
public Human findOne(int id){return  repo.findOne(id);}
   public void updateHuman( String login, String passw, String prevLog){repo.updateHuman(login,passw,prevLog);}

}
