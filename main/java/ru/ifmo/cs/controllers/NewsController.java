package ru.ifmo.cs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cs.domain.News;
import ru.ifmo.cs.services.NewsService;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 20.11.2017.
 */
@RestController
public class NewsController {
    @Autowired
    private NewsService service ;
    @RequestMapping("auth/news/offer")
    public  void addNews(HttpServletResponse rsp,@RequestParam(value = "name") String name, @RequestParam(value = "content") String body){
        try{
        News news = new News();
        news.setName(name);
        news.setBody(body);
        news.setDateAdd(new Timestamp(System.currentTimeMillis()));
        news.setModerated(false);
        service.save(news);
        rsp.sendRedirect("http://localhost:8080/offer.html");
        } catch (Exception e){}
    }
    @RequestMapping("/news/getbyname")
    public List<News> findByName(@RequestParam(value = "name") String name){
        return service.findByName(name,true);
    }
    @RequestMapping("/news/remold")
    public void removeOld(Timestamp stamp){
        service.removeIfDateIsBefore(stamp);
    }
    @RequestMapping("/news/rem")
    public void remove(@RequestParam(value = "id") int id){
        service.remove(id);
    }
    //todo fix delete!
    @RequestMapping("/news/findfresh")
    public List<News> findFresh(Timestamp stamp){
        return service.findByDateAddIsAfter(stamp,true);
    }
    @RequestMapping("/news/findold")
    public List<News> findOld(Timestamp stamp){
        return service.findByDateAddBefore(stamp, true);
    }
    @RequestMapping("/news/findall")
    public List<News> findAll(){
        return service.findByModerated(true);
    }
    @RequestMapping("/news/findunmod")
    public List<News> findUnmod(){
        return service.findByModerated(false);
    }
    @RequestMapping("/news/findOne")
    public News findOne(int id){
        return service.findOne(id);
    }
}
