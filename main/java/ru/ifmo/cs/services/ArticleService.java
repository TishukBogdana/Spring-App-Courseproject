package ru.ifmo.cs.services;


import ru.ifmo.cs.domain.Article;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface ArticleService {
    List<Article> findByName(String name, boolean mod);


    List<Article> findByDateAddIsAfter(Timestamp date,boolean mod);
    List<Article> findByDateAddIsBefore(Timestamp date);
    List<Article> findByModerated(boolean moderated);

    Iterable<Article> findAll();
    void delete(Article article);
   void save(Article article);
   Article findOne(int id);
    void remove(int id);

    void update(int id,boolean mod, Timestamp stamp);
}
