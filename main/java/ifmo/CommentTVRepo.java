package ifmo;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */
public interface CommentTVRepo extends CrudRepository<CommentOnTvSeries, Integer> {

    List<CommentOnTvSeries> findByAuthor(Human author);

    @Modifying
    @Transactional
    @Query("delete from CommentOnTvSeries  com where com.author =?1")
   void removeByAuthor(Human author);
}
