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

public class CommentOnNewsServiceImpl  implements CommentOnNewsService{
    @Autowired
    private CommentNewsRepo repo;

    public List<CommentOnNews> findByAuthor(Human author){return repo.findByAuthor(author);}

    public List<CommentOnNews> findByNews(News news){return repo.findByNews(news);}

    public void removeByNews(News news){repo.removeByNews(news);}

    public void removeByAuthor(Human author){repo.removeByAuthor(author);}
  public   Iterable<CommentOnNews> findAll(){return repo.findAll();}
   public CommentOnNews findOne(int id){return repo.findOne(id);}
  public   void delete(CommentOnNews comment){repo.delete(comment);}
   public void save(CommentOnNews comment){repo.save(comment);}
    public void updateComment(String content, Timestamp stamp, int id){repo.updateComment(content, stamp,id);}
}
