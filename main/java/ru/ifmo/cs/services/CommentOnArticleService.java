package ru.ifmo.cs.services;



import ru.ifmo.cs.domain.CommentOnArticle;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnArticleService  {


    void remove(int id);

    Iterable<CommentOnArticle> findAll();
    CommentOnArticle findOne(int id);
    void delete(CommentOnArticle comment);
    void save(CommentOnArticle comment);
    void updateComment(String content, Timestamp stamp, int id);
}
