package ru.ifmo.cs.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cs.domain.CommentOnNews;
import ru.ifmo.cs.services.CommentOnNewsService;
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
    private NewsService nService;
    @RequestMapping("/nwscom/getAll")
    public Iterable<CommentOnNews> findAll(){
        return service.findAll();
    }



    @RequestMapping("/nwscom/rembynews")
    public void removeByNews(@RequestParam(value = "id")int id){

        service.remove(id);
    }
    @RequestMapping("/nwscom/upd")
    public void update(@RequestParam(value = "id") int id, @RequestParam(value = "content") String content){
        service.updateComment(content, new Timestamp(System.currentTimeMillis()), id);
    }
    @RequestMapping("/nwscom/add")
    public void add(  @RequestParam(value = "content") String content){
    CommentOnNews comment = new CommentOnNews();

        comment.setContent(content);
        comment.setDateAdd(new Timestamp(System.currentTimeMillis()));
        service.save(comment);
    }
}
