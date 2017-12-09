package ru.ifmo.cs.servimplementations;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import ru.ifmo.cs.domain.Article;
import ru.ifmo.cs.domain.CommentOnArticle;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.repository.CommentArticleRepo;
import ru.ifmo.cs.services.CommentOnArticleService;


import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
@Service

public class CommentOnArticleServiceImpl implements CommentOnArticleService {
    @Autowired
    private CommentArticleRepo repo;

    public List<CommentOnArticle> findByArticle(Article article){return repo.findByArticle(article);}

    public     void removeByArticle(Article article){repo.removeByArticle(article);}
 public   Iterable<CommentOnArticle> findAll(){return repo.findAll();}
   public CommentOnArticle findOne(int id){return repo.findOne(id);}
    public void delete(CommentOnArticle comment){repo.delete(comment);}
    public  void save(CommentOnArticle comment){repo.save(comment);}
   public void updateComment(String content, Timestamp stamp, int id){repo.updateComment(content, stamp,id);}

}
