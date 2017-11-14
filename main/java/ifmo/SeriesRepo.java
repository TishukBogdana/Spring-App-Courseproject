package ifmo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */
public interface SeriesRepo extends CrudRepository<Series, Integer>{
    List<Series> findByName(String name);
    @Modifying
    @Transactional
    @Query("delete from Series s where s.name =?1")
    void removeByName(String name);
}
