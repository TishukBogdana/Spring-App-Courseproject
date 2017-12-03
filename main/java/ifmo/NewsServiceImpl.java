package ifmo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
@Service

public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepo repo;
    public    List<News> findByName(String name){return repo.findByName(name);}
    public List<News> findByDateAddIsAfter(Timestamp date){return repo.findByDateAddIsAfter(date);}
    public List<News> findByDateAddBefore(Timestamp date){return repo.findByDateAddBefore(date);}
    public void removeIfDateIsBefore(Timestamp date){repo.removeIfDateIsBefore(date);}
    public void removeByName(String name){repo.removeByName(name);}
    public Iterable<News> findAll(){return repo.findAll();}
    public News findOne(int id){return repo.findOne(id);}
    public   void delete(News news){repo.delete(news);}
    public void save(News news){repo.save(news);}
}
