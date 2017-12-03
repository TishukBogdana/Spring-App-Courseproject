package ifmo;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 04.12.2017.
 */
public interface AbstractCommentServ {
    List<CommentOnNews> findByAuthor(Human author);
    void removeByAuthor(Human author);
    Iterable<CommentOnNews> findAll();
    CommentOnNews findOne(int id);
    void delete(CommentOnNews comment);
    void save(CommentOnNews comment);
    void updateComment(String content, Timestamp stamp, int id);
}
