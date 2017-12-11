package ru.ifmo.cs.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cs.domain.CommentOnTvSeries;
import ru.ifmo.cs.services.CommentOnTVSeriesService;

import java.sql.Timestamp;

/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class CommentOnTVController {
    @Autowired
    private CommentOnTVSeriesService service;

@RequestMapping("/tvcom/upd")
    public void update(@RequestParam(value = "content" ) String content, @RequestParam(value = "id") int id){
        service.updateComment(content,new Timestamp(System.currentTimeMillis()), id);
    }
    @RequestMapping("/auth/tvcom/add")
   public void addComment(  @RequestParam(value = "content") String content){
       CommentOnTvSeries comment  = new CommentOnTvSeries();
       comment.setContent(content);
       comment.setDateAdd(new Timestamp(System.currentTimeMillis()));
       service.save(comment);
    }

    @RequestMapping("/tvcom/getall")
    public Iterable<CommentOnTvSeries> findAll(){
        return  service.findAll();
    }
}
