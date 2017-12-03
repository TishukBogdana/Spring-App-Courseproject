package ifmo;



import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnArticleService extends AbstractCommentServ {
    List<CommentOnArticle> findByArticle(Article article);

    void removeByArticle(Article article);

}
