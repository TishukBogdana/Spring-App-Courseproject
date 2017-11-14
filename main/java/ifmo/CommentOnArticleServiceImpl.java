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

public class CommentOnArticleServiceImpl implements CommentOnArticleService {
    @Autowired
    private CommentArticleRepo repo;
   public List<CommentOnArticle> findByAuthor(Human author){return repo.findByAuthor(author);}
    public List<CommentOnArticle> findByArticle(Article article){return repo.findByArticle(article);}

    public     void removeByArticle(Article article){repo.removeByArticle(article);}
    public void removeByAuthor(Human author){repo.removeByAuthor(author);}
 public   Iterable<CommentOnArticle> findAll(){return repo.findAll();}
   public CommentOnArticle findOne(int id){return repo.findOne(id);}
    public void delete(CommentOnArticle comment){repo.delete(comment);}
    public  void save(CommentOnArticle comment){repo.save(comment);}
}
