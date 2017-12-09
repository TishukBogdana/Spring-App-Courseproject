package ru.ifmo.cs.services;



import ru.ifmo.cs.domain.CommentOnSeries;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.domain.Series;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface CommentOnSeriesService  {


    List<CommentOnSeries> findBySeries(Series series);
    void removeBySeries(Series series);

    Iterable<CommentOnSeries> findAll();
    CommentOnSeries findOne(int id);
    void delete(CommentOnSeries comment);
    void save(CommentOnSeries comment);
    void updateComment(String content, Timestamp stamp, int id);
}
