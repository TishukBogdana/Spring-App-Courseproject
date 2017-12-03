package ifmo;



import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnSeriesService extends AbstractCommentServ {


    List<CommentOnSeries> findBySeries(Series series);
    void removeBySeries(Series series);

}
