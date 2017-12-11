package ru.ifmo.cs.servimplementations;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;
import ru.ifmo.cs.domain.Article;
import ru.ifmo.cs.repository.ArticleRepo;
import ru.ifmo.cs.services.ArticleService;


import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
@Service


public class ArticleServiceImpl implements ArticleService {
    @Autowired
    private ArticleRepo repo;
    public List<Article> findByName(String name, boolean mod){return repo.findByNameAndModerated(name,mod);}


    public List<Article> findByDateAddIsAfter(Timestamp date,boolean mod){return repo.findByDateAddIsAfterAndModerated(date,mod);}
    public List<Article> findByDateAddIsBefore(Timestamp date){return repo.findByDateAddIsBefore(date);}
    public List<Article> findByModerated(boolean moderated){return repo.findByModerated(moderated);}

    public    Iterable<Article> findAll(){return repo.findAll();}
   public void delete(Article article){repo.delete(article);}
    public void save(Article article){repo.save(article);}
    public Article findOne(int id){return repo.findOne(id);}
   public void remove(int id){ repo.remove(id);}
  public   void update(int id ,String name, String body, Timestamp stamp){repo.update(id, name, body,stamp);}
}
