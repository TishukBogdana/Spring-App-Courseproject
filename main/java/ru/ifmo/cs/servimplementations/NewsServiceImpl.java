package ru.ifmo.cs.servimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.cs.domain.News;
import ru.ifmo.cs.repository.NewsRepo;
import ru.ifmo.cs.services.NewsService;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
@Service

public class NewsServiceImpl implements NewsService {
    @Autowired

    private NewsRepo repo;
    public    List<News> findByName(String name, boolean mod){return repo.findByNameAndModerated(name,mod);}
    public List<News> findByDateAddIsAfter(Timestamp date, boolean mod){return repo.findByDateAddIsAfterAndModerated(date, mod);}
    public List<News> findByDateAddBefore(Timestamp date, boolean mod){return repo.findByDateAddBeforeAndModerated(date, mod);}
    public List<News> findByModerated(boolean moderated){return repo.findByModerated(moderated);}
    public void removeIfDateIsBefore(Timestamp date){repo.removeIfDateIsBefore(date);}
    public void remove(int id){repo.remove(id);}
    public Iterable<News> findAll(){return repo.findAll();}
    public News findOne(int id){return repo.findOne(id);}
    public   void delete(News news){repo.delete(news);}
    public void save(News news){repo.save(news);}
}
