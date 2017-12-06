package ru.ifmo.cs.servimplementations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ifmo.cs.domain.Series;
import ru.ifmo.cs.repository.SeriesRepo;
import ru.ifmo.cs.services.SeriesService;

import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
@Service

public class SeriesServiceImpl implements SeriesService {
    @Autowired

    private SeriesRepo repo;
 public List<Series> findByName(String name){return repo.findByName(name);}
    public void removeByName(String name){repo.removeByName(name);}
   public Iterable<Series> findAll(){return repo.findAll();}
   public Series findOne(int id){return repo.findOne(id);}
   public void save(Series series){repo.save(series);}
    public void delete (Series series){repo.delete(series);}
 public    void updateSeries(String name, String descr, String prevName){repo.updateSeries(name, descr, prevName);}

}
