package ru.ifmo.cs.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.ifmo.cs.domain.Article;
import ru.ifmo.cs.domain.CommentOnArticle;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.services.ArticleService;
import ru.ifmo.cs.services.CommentOnArticleService;
import ru.ifmo.cs.services.HumanService;

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
    private HumanService hService;
    @Autowired
    private ArticleService aService;
    @RequestMapping("/artcom/getall")
    public Iterable<CommentOnArticle> findAll(){
        return service.findAll();
    }
    @RequestMapping("/artcom/getbyauth")
    public List<CommentOnArticle> findByAuthor(@RequestParam(value = "login") String login){
        Human author  =  hService.findByLogin(login).get(0);
        return service.findByAuthor(author);
    }
    @RequestMapping("/artcom/getbyart")
    public List<CommentOnArticle> findByArticle(@RequestParam(value = "article")int id){
        Article article = aService.findOne(id);
        return service.findByArticle(article);
    }
    @RequestMapping("/artcom/rembyauth")
    public void removeByAuthor(@RequestParam(value = "author") String login){
        Human author  =  hService.findByLogin(login).get(0);
       service.removeByAuthor(author);
    }
    @RequestMapping("/artcom/rembyart")
    public void removeByArticle(@RequestParam(value = "article")int id){
        Article article = aService.findOne(id);
        service.removeByArticle(article);
    }
    @RequestMapping("/artcom/upd")
    public void update(@RequestParam(value = "id") int id, @RequestParam(value = "content") String content){
        service.updateComment(content, new Timestamp(System.currentTimeMillis()), id);
    }
    @RequestMapping("/artcom/add")
    public void add( @RequestParam(value = "reply") int id_com, @RequestParam(value = "author") String login, @RequestParam(value = "article")int id_art, @RequestParam(value = "content") String content){
      CommentOnArticle comment = new CommentOnArticle();
      Human author = hService.findByLogin(login).get(0);
      Article article = aService.findOne(id_art);
      CommentOnArticle reply = service.findOne(id_com);
      comment.setOnComment(reply);
      comment.setArticle(article);
      comment.setAuthor(author);
      comment.setContent(content);
      comment.setDateAdd(new Timestamp(System.currentTimeMillis()));
      service.save(comment);
    }
}
