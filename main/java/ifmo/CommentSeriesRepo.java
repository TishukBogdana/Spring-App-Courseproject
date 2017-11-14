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
public interface CommentSeriesRepo extends CrudRepository<CommentOnSeries, Integer> {
    List<CommentOnSeries> findByAuthor(Human author);
    List<CommentOnSeries> findBySeries(Series series);
    @Modifying
    @Transactional
    @Query("delete from CommentOnSeries  com where com.series =?1")
    void removeBySeries(Series series);
    @Modifying
    @Transactional
    @Query("delete from CommentOnArticle  com where com.author =?1")
     void removeByAuthor(Human author);
}
