package ifmo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */
public interface HumanRepo extends CrudRepository<Human, Integer> {
    List<Human> findByName(String name);
    List<Human>  findBySurname(String sirname);
    List<Human> findByLogin(String login);
    List<Human> findByNameAndSurname(String name, String sirname);
    @Modifying
    @Transactional
    @Query("delete from Human  human where human.login =?1")
    void removeByLogin(String login);
}
