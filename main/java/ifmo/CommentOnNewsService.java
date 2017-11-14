package ifmo;

import org.springframework.data.jpa.repository.Modifying;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnNewsService {

    List<CommentOnNews> findByAuthor(Human author);

    List<CommentOnNews> findByNews(News news);

    void removeByNews(News news);

    void removeByAuthor(Human author);
    Iterable<CommentOnNews> findAll();
    CommentOnNews findOne(int id);
    void delete(CommentOnNews comment);
    void save(CommentOnNews comment);
    void updateComment(String content, Timestamp stamp, int id);


}
