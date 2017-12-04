package ifmo;



import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnSeriesService  {


    List<CommentOnSeries> findBySeries(Series series);
    void removeBySeries(Series series);
    List<CommentOnSeries> findByAuthor(Human author);
    void removeByAuthor(Human author);
    Iterable<CommentOnSeries> findAll();
    CommentOnSeries findOne(int id);
    void delete(CommentOnSeries comment);
    void save(CommentOnSeries comment);
    void updateComment(String content, Timestamp stamp, int id);
}
