package ifmo;


import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface ArticleService {
    List<Article> findByName(String name);
    List<Article> findByAuthor(Human author);
    List<Article> findByNameAndAuthor(String name, Human author);
    List<Article> findByDateAddIsAfter(Timestamp date);
    List<Article> findByDateAddIsBefore(Timestamp date);
    Iterable<Article> findAll();
    void delete(Article article);
   void save(Article article);
   Article findOne(int id);
    void removeByName(String name);
    void removeByAuthor(Human author);
    void updateByNameAndBody(String prev , Human author, String name, String body, Timestamp stamp);
}
