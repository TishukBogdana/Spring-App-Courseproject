package ru.ifmo.cs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.ifmo.cs.domain.Article;
import ru.ifmo.cs.domain.News;
import ru.ifmo.cs.services.ArticleService;
import ru.ifmo.cs.services.NewsService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 20.11.2017.
 */
@RestController
public class ArticleController {
    @Autowired
  private ArticleService service ;

    @Autowired
    private NewsService nService;
  @GetMapping("/articles/getlast")
    public List<Article> getForPage(){
      Timestamp defTime = new Timestamp(System.currentTimeMillis()-864000000);
        return service.findByDateAddIsAfter(defTime,true);
    }
    @GetMapping("/articles/getname")
    public List<Article> getByName(@RequestParam(value = "name") String name){
        return  service.findByName(name,true);
    }

 @PostMapping("/auth/articles/rem")
  public void remove(@RequestParam(value = "id") int id, HttpServletResponse resp, HttpServletRequest req) throws  Exception{
     String log =(String) req.getSession().getAttribute("login");
     if(log==null){resp.sendRedirect("http://localhost:8080/errorpage.html");}
 else{ service.remove(id);
  resp.sendRedirect("http://localhost:8080/adminpanel.html");}
  }

  @PostMapping("/auth/articles/upd")
  public void update(@RequestParam(value ="id") int id, HttpServletResponse resp, HttpServletRequest req) throws Exception{
    String log =(String) req.getSession().getAttribute("login");
    if(log==null){resp.sendRedirect("http://localhost:8080/errorpage.html");}
    else{    service.update(id,true , new Timestamp(System.currentTimeMillis()));
      resp.sendRedirect("http://localhost:8080/adminpanel.html");}

  }
  @PostMapping("/auth/article/offer")
 public void addArticle( HttpServletResponse rsp,@RequestParam (value = "name") String name, @RequestParam(value = "content") String body ){
      try {
          Article article = new Article();
          article.setName(name);
          article.setBody(body);
          article.setDateAdd(new Timestamp(System.currentTimeMillis()));
          article.setModerated(false);
          service.save(article);
          News news = new News();
          news.setDateAdd(new Timestamp(System.currentTimeMillis()));
          news.setName("New article added");
          news.setBody("new article" + name);
          news.setModerated(false);
          nService.save(news);
          rsp.sendRedirect("http://localhost:8080/articles.html");
      }catch (Exception e){}
  }

    @RequestMapping("/article/findone")
    public  Article findOne(int id){
     return service.findOne(id);
    }

    @RequestMapping("/articles/all")
    public ResponseEntity<List<Article>> findAll(){return new ResponseEntity<List<Article>>(service.findByModerated(true),HttpStatus.OK) ;}
    @RequestMapping("/articles/unmod")
    public List<Article> findUnmod(){
        return service.findByModerated(false);
    }
}
