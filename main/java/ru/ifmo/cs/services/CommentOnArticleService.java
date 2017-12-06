package ru.ifmo.cs.services;



import ru.ifmo.cs.domain.Article;
import ru.ifmo.cs.domain.CommentOnArticle;
import ru.ifmo.cs.domain.Human;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnArticleService  {
    List<CommentOnArticle> findByArticle(Article article);

    void removeByArticle(Article article);
    List<CommentOnArticle> findByAuthor(Human author);
    void removeByAuthor(Human author);
    Iterable<CommentOnArticle> findAll();
    CommentOnArticle findOne(int id);
    void delete(CommentOnArticle comment);
    void save(CommentOnArticle comment);
    void updateComment(String content, Timestamp stamp, int id);
}
