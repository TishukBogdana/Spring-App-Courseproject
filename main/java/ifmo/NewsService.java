package ifmo;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface NewsService {
    List<News> findByName(String name);
    List<News> findByDateAddIsAfter(Timestamp date);
    List<News> findByDateAddBefore(Timestamp date);
    void removeIfDateIsBefore(Timestamp date);
    void removeByName(String name);
    Iterable<News> findAll();
    News findOne(int id);
    void delete(News news);
    void save(News news);
}
