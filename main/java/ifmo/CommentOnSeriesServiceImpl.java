package ifmo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
@Service

public class CommentOnSeriesServiceImpl implements CommentOnSeriesService {
    @Autowired
    private CommentSeriesRepo repo;
    public List<CommentOnSeries> findByAuthor(Human author){return repo.findByAuthor(author);}
    public List<CommentOnSeries> findBySeries(Series series){return repo.findBySeries(series);}
    public void removeBySeries(Series series){repo.removeBySeries(series);}
    public void removeByAuthor(Human author){repo.removeByAuthor(author);}
  public   Iterable<CommentOnSeries> findAll(){return repo.findAll();}
    public CommentOnSeries findOne(int id){return repo.findOne(id);}
    public void delete(CommentOnSeries comment){repo.delete(comment);}
    public void save(CommentOnSeries comment){repo.save(comment);}
}
