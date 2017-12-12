package ru.ifmo.cs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.cs.domain.CommentOnArticle;
import ru.ifmo.cs.services.ArticleService;
import ru.ifmo.cs.services.CommentOnArticleService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 04.12.2017.
 */
@RestController
public class CommentOnArticleController {
    @Autowired
    private CommentOnArticleService service;

    @Autowired
    private ArticleService aService;
    @RequestMapping("/artcom/getall")
    public Iterable<CommentOnArticle> findAll(){
        return service.findAll();
    }



    @RequestMapping("/auth/artcom/rem")
    public void removeByArticle(@RequestParam(value = "id")int id, HttpServletResponse rsp, HttpServletRequest req)  throws  Exception{
        String log =(String) req.getSession().getAttribute("login");
        if(log==null){rsp.sendRedirect("http://localhost:8080/errorpage.html");}
        else{service.remove(id);
        rsp.sendRedirect("http://localhost:8080/adminpanel.html");}
    }
    @RequestMapping("/auth/artcom/upd")
    public void update(@RequestParam(value = "id") int id, @RequestParam(value = "content") String content){
        service.updateComment(content, new Timestamp(System.currentTimeMillis()), id);
    }
    @RequestMapping("/auth/artcom/add")
    public void add(@RequestParam(value = "content") String content, HttpServletResponse resp){
        try {
            CommentOnArticle comment = new CommentOnArticle();


            comment.setContent(content);
            comment.setDateAdd(new Timestamp(System.currentTimeMillis()));
            service.save(comment);
            resp.sendRedirect("http://localhost:8080/articles.html");
        }catch (Exception e){}
    }
}
