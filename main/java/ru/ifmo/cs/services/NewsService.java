package ru.ifmo.cs.services;

import ru.ifmo.cs.domain.News;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public interface NewsService {
    List<News> findByName(String name, boolean mod);
    List<News> findByDateAddIsAfter(Timestamp date, boolean mod);
    List<News> findByDateAddBefore(Timestamp date, boolean mod);
    List<News> findByModerated(boolean moderated);
    void removeIfDateIsBefore(Timestamp date);
    void remove(int id);
    Iterable<News> findAll();
    News findOne(int id);
    void delete(News news);
    void save(News news);
}
