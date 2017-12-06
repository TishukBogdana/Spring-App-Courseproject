package ru.ifmo.cs.servimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.cs.domain.Person;
import ru.ifmo.cs.repository.PersonRepo;
import ru.ifmo.cs.services.PersonService;

import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
@Service

public class PersonServiceImpl implements PersonService {
    @Autowired

    private PersonRepo repo;
 public    List<Person> findByNameAndSurname(String name, String surmname){return repo.findByNameAndSurname(name, surmname);}

  public   void removeByNameAndSirname(String name, String surname){repo.removeByNameAndSirname(name, surname);}
   public Iterable<Person> findAll(){return repo.findAll();}
  public   Person findOne(int id){return repo.findOne(id);}
  public   void delete(Person person){repo.delete(person);}
   public void save(Person person){repo.save(person);}
   public void updatePerson(String name,String surname, String descr, String prevName, String prevSurname){repo.updatePerson(name, surname,descr,prevName,prevSurname);}

}
