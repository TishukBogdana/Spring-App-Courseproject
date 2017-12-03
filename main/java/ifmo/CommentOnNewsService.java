package ifmo;

import org.springframework.data.jpa.repository.Modifying;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnNewsService extends AbstractCommentServ {



    List<CommentOnNews> findByNews(News news);

    void removeByNews(News news);


}
