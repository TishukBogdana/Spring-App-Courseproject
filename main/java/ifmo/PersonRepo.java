package ifmo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */
public interface PersonRepo extends CrudRepository<Person, Integer> {
    List<Person> findByNameAndSurname(String name, String surname);
    @Modifying
    @Transactional
    @Query("delete from Person person where person.name = ?1 and person.surname =?2")
    void removeByNameAndSirname(String name, String Sirname);
}
