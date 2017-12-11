package ru.ifmo.cs.servimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.cs.domain.CommentOnNews;
import ru.ifmo.cs.repository.CommentNewsRepo;
import ru.ifmo.cs.services.CommentOnNewsService;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
@Service

public class CommentOnNewsServiceImpl  implements CommentOnNewsService {
    @Autowired
    private CommentNewsRepo repo;




    public void remove(int id){repo.remove(id);}

  public   Iterable<CommentOnNews> findAll(){return repo.findAll();}
   public CommentOnNews findOne(int id){return repo.findOne(id);}
  public   void delete(CommentOnNews comment){repo.delete(comment);}
   public void save(CommentOnNews comment){repo.save(comment);}
    public void updateComment(String content, Timestamp stamp, int id){repo.updateComment(content, stamp,id);}
}
