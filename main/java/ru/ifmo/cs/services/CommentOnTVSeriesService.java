package ru.ifmo.cs.services;

import ru.ifmo.cs.domain.CommentOnTvSeries;
import ru.ifmo.cs.domain.Human;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnTVSeriesService {
    List<CommentOnTvSeries> findByAuthor(Human author);
    void removeByAuthor(Human author);
    Iterable<CommentOnTvSeries> findAll();
    CommentOnTvSeries findOne(int id);
    void delete(CommentOnTvSeries comment);
    void save(CommentOnTvSeries comment);
    void updateComment(String content, Timestamp stamp, int id);
    //todo fix update!
}
