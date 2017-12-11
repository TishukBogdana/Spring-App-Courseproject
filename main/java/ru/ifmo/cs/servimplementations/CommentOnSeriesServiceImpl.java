package ru.ifmo.cs.servimplementations;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.cs.domain.CommentOnSeries;
import ru.ifmo.cs.repository.CommentSeriesRepo;
import ru.ifmo.cs.services.CommentOnSeriesService;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */

@Service

public class CommentOnSeriesServiceImpl implements CommentOnSeriesService {
    @Autowired
    private CommentSeriesRepo repo;


    public void remove(int id){repo.remove(id);}
  public   Iterable<CommentOnSeries> findAll(){return repo.findAll();}
    public CommentOnSeries findOne(int id){return repo.findOne(id);}
    public void delete(CommentOnSeries comment){repo.delete(comment);}
    public void save(CommentOnSeries comment){repo.save(comment);}
    public void updateComment(String content, Timestamp stamp, int id){repo.updateComment(content, stamp,id);}

}
