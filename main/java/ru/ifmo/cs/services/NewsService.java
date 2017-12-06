package ru.ifmo.cs.services;

import ru.ifmo.cs.domain.News;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface NewsService {
    List<News> findByName(String name);
    List<News> findByDateAddIsAfter(Timestamp date);
    List<News> findByDateAddBefore(Timestamp date);
    List<News> findByModerated(boolean moderated);
    void removeIfDateIsBefore(Timestamp date);
    void removeByName(String name);
    Iterable<News> findAll();
    News findOne(int id);
    void delete(News news);
    void save(News news);
}
