package ifmo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */
public interface CommentNewsRepo extends CrudRepository<CommentOnNews, Integer> {
    List<CommentOnNews> findByAuthor(Human author);
    List<CommentOnNews> findByNews(News news);
    @Modifying
    @Transactional
    @Query("delete from CommentOnNews  com where com.news =?1")
 void removeByNews(News news);
    @Modifying
    @Transactional
    @Query("delete from CommentOnNews com where com.author = ?1")
     void removeByAuthor(Human author);
}
