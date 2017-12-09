package ru.ifmo.cs.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cs.domain.CommentOnSeries;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.domain.Series;
import ru.ifmo.cs.services.CommentOnSeriesService;
import ru.ifmo.cs.services.HumanService;
import ru.ifmo.cs.services.SeriesService;

import java.sql.Timestamp;
import java.util.List;


/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class CommentOnSeriesController {
    @Autowired
    private CommentOnSeriesService service;
    @Autowired
    private SeriesService sService;

    @RequestMapping("/sercom/getall")
    public Iterable<CommentOnSeries> findAll(){
        return service.findAll();
    }
    @RequestMapping("/sercom/getbyser")
    public List<CommentOnSeries> finfBySeries(@RequestParam(value = "seria") int id_seria){
        Series seria = sService.findOne(id_seria);
        return service.findBySeries(seria);
    }

    @RequestMapping("/sercom/rembyser")
    public void removeBySeries(@RequestParam(value = "seria") int id_seria){
        Series seria = sService.findOne(id_seria);
        service.removeBySeries(seria);
    }

    @RequestMapping("/sercom/upd")
    public void update(@RequestParam(value = "id") int id, @RequestParam(value = "content") String content){
        service.updateComment(content, new Timestamp(System.currentTimeMillis()), id);
    }
    @RequestMapping("/sercom/add")
    public void add(  @RequestParam(value = "news") int id_series, @RequestParam(value = "content") String content){
        CommentOnSeries comment  = new CommentOnSeries();
        Series series = sService.findOne(id_series);
        comment.setSeries(series);
        comment.setContent(content);
        comment.setDateAdd( new Timestamp(System.currentTimeMillis()));
        service.save(comment);
    }
}
