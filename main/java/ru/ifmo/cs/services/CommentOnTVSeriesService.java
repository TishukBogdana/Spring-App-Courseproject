package ru.ifmo.cs.services;

import ru.ifmo.cs.domain.CommentOnTvSeries;

import java.sql.Timestamp;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnTVSeriesService {

    Iterable<CommentOnTvSeries> findAll();
    CommentOnTvSeries findOne(int id);
    void remove(int id);
    void save(CommentOnTvSeries comment);
    void updateComment(String content, Timestamp stamp, int id);
    //todo fix update!
}
