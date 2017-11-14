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

public class CommentOnTVSeriesImpl implements CommentOnTVSeriesService {
    @Autowired
    private CommentTVRepo repo;

    public List<CommentOnTvSeries> findByAuthor(Human author){return repo.findByAuthor(author);}
    public void removeByAuthor(Human author){repo.removeByAuthor(author);}
 public    Iterable<CommentOnTvSeries> findAll(){return repo.findAll();}
   public CommentOnTvSeries findOne(int id){return repo.findOne(id);}
  public   void delete(CommentOnTvSeries comment){repo.delete(comment);}
  public   void save(CommentOnTvSeries comment){repo.save(comment);}
    public void updateComment(String content, Timestamp stamp, int id){repo.updateComment(content, stamp,id);}

}
