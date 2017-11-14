package ifmo;



import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnArticleService {
    List<CommentOnArticle> findByAuthor(Human author);
    List<CommentOnArticle> findByArticle(Article article);

    void removeByArticle(Article article);
    void removeByAuthor(Human author);
    Iterable<CommentOnArticle> findAll();
    CommentOnArticle findOne(int id);
    void delete(CommentOnArticle comment);
    void save(CommentOnArticle comment);
}
