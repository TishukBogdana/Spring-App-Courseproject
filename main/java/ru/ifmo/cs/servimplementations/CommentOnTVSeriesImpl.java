package ru.ifmo.cs.servimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.cs.domain.CommentOnTvSeries;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.repository.CommentTVRepo;
import ru.ifmo.cs.services.CommentOnTVSeriesService;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */

@Service

public class CommentOnTVSeriesImpl implements CommentOnTVSeriesService {
    @Autowired

    private CommentTVRepo repo;


 public    Iterable<CommentOnTvSeries> findAll(){return repo.findAll();}
   public CommentOnTvSeries findOne(int id){return repo.findOne(id);}
  public   void delete(CommentOnTvSeries comment){repo.delete(comment);}
  public   void save(CommentOnTvSeries comment){repo.save(comment);}
    public void updateComment(String content, Timestamp stamp, int id){repo.updateComment(content, stamp,id);}

}
