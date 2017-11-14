package ifmo;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnTVSeriesService {

    List<CommentOnTvSeries> findByAuthor(Human author);
    void removeByAuthor(Human author);
    Iterable<CommentOnTvSeries> findAll();
    CommentOnTvSeries findOne(int id);
    void delete(CommentOnTvSeries comment);
    void save(CommentOnTvSeries comment);
    void updateComment(String content, Timestamp stamp, int id);

}
