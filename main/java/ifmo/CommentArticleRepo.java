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
public interface CommentArticleRepo extends CrudRepository<CommentOnArticle, Integer>{
    List<CommentOnArticle> findByAuthor(Human author);
    List<CommentOnArticle> findByArticle(Article article);

  @Modifying
    @Transactional
    @Query("delete from CommentOnArticle  com where com.article =?1")
  void removeByArticle(Article article);
    @Modifying
    @Transactional
    @Query("delete from CommentOnArticle  com where com.author = ?1")
 void removeByAuthor(Human author);
}
