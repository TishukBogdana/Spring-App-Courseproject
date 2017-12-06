package ru.ifmo.cs.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cs.services.CommentOnTVSeriesService;
import ru.ifmo.cs.domain.CommentOnTvSeries;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.services.HumanService;

import java.sql.Timestamp;
import java.util.*;

/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class CommentOnTVController {
    @Autowired
    private CommentOnTVSeriesService service;
    @Autowired
    private static HumanService hService;
@RequestMapping("/tvcom/upd")
    public void update(@RequestParam(value = "content" ) String content, @RequestParam(value = "id") int id){
        service.updateComment(content,new Timestamp(System.currentTimeMillis()), id);
    }
    @RequestMapping("/tvcom/add")
   public void addComment( @RequestParam(value = "reply") int com, @RequestParam(value = "author")String login, @RequestParam(value = "content") String content){
       Human author  = hService.findByLogin(login).get(0);
       CommentOnTvSeries comment  = new CommentOnTvSeries();
       comment.setContent(content);
       comment.setAuthor(author);
       comment.setDateAdd(new Timestamp(System.currentTimeMillis()));
       comment.setCommentOnTvSeriesByOnComment(service.findOne(com));
       service.save(comment);
    }
    @RequestMapping("/tvcom/rembyauth")
    public void removeByAuthor(@RequestParam (value = "author") String login){
        Human author = hService.findByLogin(login).get(0);
        service.removeByAuthor(author);
    }
    @RequestMapping("/tvcom/getbyauth")
    public List<CommentOnTvSeries> findByAuthor(@RequestParam (value = "author") String login){
        Human author = hService.findByLogin(login).get(0);
    return   service.findByAuthor(author);
    }
    @RequestMapping("/tvcom/getall")
    public Iterable<CommentOnTvSeries> findAll(){
        return  service.findAll();
    }
}
