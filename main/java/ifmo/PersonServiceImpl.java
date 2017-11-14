package ifmo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
@Service

public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonRepo repo;
 public    List<Person> findByNameAndSurname(String name, String surmname){return repo.findByNameAndSurname(name, surmname);}

  public   void removeByNameAndSirname(String name, String surname){repo.removeByNameAndSirname(name, surname);}
   public Iterable<Person> findAll(){return repo.findAll();}
  public   Person findOne(int id){return repo.findOne(id);}
  public   void delete(Person person){repo.delete(person);}
   public void save(Person person){repo.save(person);}
}
