package ru.ifmo.cs.controllers;

import ru.ifmo.cs.domain.News;
import ru.ifmo.cs.services.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 20.11.2017.
 */
@RestController
public class NewsController {
    @Autowired
    private NewsService service ;
    @RequestMapping("/news/offer")
    public  void addNews(@RequestParam(value = "name") String name, @RequestParam(value = "body") String body){
        News news = new News();
        news.setName(name);
        news.setBody(body);
        news.setDateAdd(new Timestamp(System.currentTimeMillis()));
        news.setModerated(false);
        service.save(news);
    }
    @RequestMapping("/news/getbyname")
    public List<News> findByName(@RequestParam(value = "name") String name){
        return service.findByName(name);
    }
    @RequestMapping("/news/remold")
    public void removeOld(Timestamp stamp){
        service.removeIfDateIsBefore(stamp);
    }
    @RequestMapping("/news/rembyname")
    public void removeByName(@RequestParam(value = "name") String name){
        service.removeByName(name);
    }
    //todo fix delete!
    @RequestMapping("/news/findfresh")
    public List<News> findFresh(Timestamp stamp){
        return service.findByDateAddIsAfter(stamp);
    }
    @RequestMapping("/news/findold")
    public List<News> findOld(Timestamp stamp){
        return service.findByDateAddBefore(stamp);
    }
    @RequestMapping("/news/findall")
    public Iterable<News> findAll(){
        return service.findAll();
    }
    @RequestMapping("/news/findOne")
    public News findOne(int id){
        return service.findOne(id);
    }
}
