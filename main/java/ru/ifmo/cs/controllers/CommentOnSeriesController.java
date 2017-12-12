package ru.ifmo.cs.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cs.domain.CommentOnSeries;
import ru.ifmo.cs.services.CommentOnSeriesService;
import ru.ifmo.cs.services.SeriesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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


    @RequestMapping("/auth/sercom/rem")
    public void removeBySeries(@RequestParam(value = "id") int id, HttpServletResponse rsp, HttpServletRequest req)throws Exception{
        String log =(String) req.getSession().getAttribute("login");
        if(log==null){rsp.sendRedirect("http://localhost:8080/errorpage.html");}
      else{   service.remove(id);
        rsp.sendRedirect("http://localhost:8080/adminpanel.html");}

    }

    @RequestMapping("/auth/sercom/upd")
    public void update(@RequestParam(value = "id") int id, @RequestParam(value = "content") String content){
        service.updateComment(content, new Timestamp(System.currentTimeMillis()), id);
    }
    @RequestMapping("auth/sercom/add")
    public void add(@RequestParam(value = "content") String content, HttpServletResponse rsp) throws Exception{
        CommentOnSeries comment  = new CommentOnSeries();

        comment.setContent(content);
        comment.setDateAdd( new Timestamp(System.currentTimeMillis()));
        service.save(comment);
        rsp.sendRedirect("http://localhost:8080/series.html");
    }
}
