package ru.ifmo.cs.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cs.domain.CommentOnNews;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.domain.News;
import ru.ifmo.cs.services.CommentOnNewsService;
import ru.ifmo.cs.services.HumanService;
import ru.ifmo.cs.services.NewsService;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class CommentOnNewsController {
    @Autowired
    private CommentOnNewsService service;
    @Autowired
    private HumanService hService;
    @Autowired
    private NewsService nService;
    @RequestMapping("/nwscom/getAll")
    public Iterable<CommentOnNews> findAll(){
        return service.findAll();
    }
    @RequestMapping("/nwscon/getbyauth")
    public List<CommentOnNews> findByAuthor(@RequestParam(value = "login") String login){
        Human author  =  hService.findByLogin(login).get(0);
        return service.findByAuthor(author);
    }
    @RequestMapping("/nwscom/getbynews")
    public List<CommentOnNews> findByNews(@RequestParam(value = "news")int id){
       News news = nService.findOne(id);
        return service.findByNews(news);
    }
    @RequestMapping("/nwscom/rembyauth")
    public void removeByAuthor(@RequestParam(value = "author") String login){
        Human author  =  hService.findByLogin(login).get(0);
        service.removeByAuthor(author);
    }
    @RequestMapping("/nwscom/rembynews")
    public void removeByNews(@RequestParam(value = "news")int id){
        News news = nService.findOne(id);
        service.removeByNews(news);
    }
    @RequestMapping("/nwscom/upd")
    public void update(@RequestParam(value = "id") int id, @RequestParam(value = "content") String content){
        service.updateComment(content, new Timestamp(System.currentTimeMillis()), id);
    }
    @RequestMapping("/nwscom/add")
    public void add( @RequestParam(value = "reply") int id_com, @RequestParam(value = "author") String login, @RequestParam(value = "news")int id_news, @RequestParam(value = "content") String content){
    CommentOnNews comment = new CommentOnNews();
        Human author = hService.findByLogin(login).get(0);
        News news = nService.findOne(id_news);
        CommentOnNews reply = service.findOne(id_com);
        comment.setOnComment(reply);
        comment.setNews(news);
        comment.setAuthor(author);
        comment.setContent(content);
        comment.setDateAdd(new Timestamp(System.currentTimeMillis()));
        service.save(comment);
    }
}
