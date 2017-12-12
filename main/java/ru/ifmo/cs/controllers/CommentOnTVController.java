package ru.ifmo.cs.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cs.domain.CommentOnTvSeries;
import ru.ifmo.cs.services.CommentOnTVSeriesService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;

/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class CommentOnTVController {
    @Autowired
    private CommentOnTVSeriesService service;

@RequestMapping("/auth/tvcom/upd")
    public void update(@RequestParam(value = "content" ) String content, @RequestParam(value = "id") int id){
        service.updateComment(content,new Timestamp(System.currentTimeMillis()), id);
    }
    @RequestMapping("/auth/tvcom/add")
   public void addComment(@RequestParam(value = "content") String content, HttpServletResponse resp) throws  Exception{
       CommentOnTvSeries comment  = new CommentOnTvSeries();
       comment.setContent(content);
       comment.setDateAdd(new Timestamp(System.currentTimeMillis()));
       service.save(comment);
       resp.sendRedirect("http://localhost:8080/mainpage.html");
    }

    @RequestMapping("/tvcom/getall")
    public Iterable<CommentOnTvSeries> findAll(){
        return  service.findAll();
    }
    @RequestMapping("/auth/tvcom/rem")
    public void rem(@RequestParam(value = "id") int id, HttpServletResponse rsp, HttpServletRequest req) throws Exception{
        String log =(String) req.getSession().getAttribute("login");
        if(log==null){rsp.sendRedirect("http://localhost:8080/errorpage.html");}
       else{ service.remove(id);
        rsp.sendRedirect("http://localhost:8080/adminpanel.html");}

    }
}
