package ru.ifmo.cs.services;

import ru.ifmo.cs.domain.CommentOnNews;
import ru.ifmo.cs.domain.News;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnNewsService  {





    void remove(int id);


    Iterable<CommentOnNews> findAll();
    CommentOnNews findOne(int id);
    void delete(CommentOnNews comment);
    void save(CommentOnNews comment);
    void updateComment(String content, Timestamp stamp, int id);
}
