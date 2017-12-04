package logic;

import ifmo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 20.11.2017.
 */
@RestController
public class ArticleController {
    @Autowired
  private   ArticleService service ;
    @Autowired
  private HumanService hService;
  @RequestMapping("/articles/getlast")
    public List<Article> getForPage(){
      Timestamp defTime = new Timestamp(System.currentTimeMillis()-864000000);
        return service.findByDateAddIsAfter(defTime);
    }
    @RequestMapping("/articles/getname")
    public List<Article> getByName(@RequestParam(value = "name") String name){
        return  service.findByName(name);
    }
    @RequestMapping("/articles/getauth")
    public List<Article> getByAuthor(@RequestParam(value="author")String login){
      Human author = hService.findByLogin(login).get(0);
      return service.findByAuthor(author);
    }
 @RequestMapping("/articles/getnameandauth")
  public List<Article> getByNameAndAuthor(@RequestParam(value = "name")String name, @RequestParam(value = "author") String login){
     Human author = hService.findByLogin(login). get(0);
      return service.findByNameAndAuthor(name, author);
 }
 @RequestMapping("/articles/rembybame")
  public void removeByName(@RequestParam(value = "name") String name){
  service.removeByName(name);
  }
  @RequestMapping("/articles/remByAuthor")
  public void removeByAuthor(@RequestParam(value = "author") String login){
    Human author = hService.findByLogin(login).get(0);
    service.removeByAuthor( author);
  }
  @RequestMapping("/article/update")
  public void update(@RequestParam(value ="prevname") String prevname, @RequestParam(value  ="author" ) String login, @RequestParam(value = "name")String name, @RequestParam(value = "body")String body){
    Human author = hService.findByLogin(login).get(0);
    service.updateByNameAndBody(prevname,author,name, body, new Timestamp(System.currentTimeMillis()));
  }
  @RequestMapping("/article/add")
 public void addArticle(@RequestParam(value = "author") String login, @RequestParam (value = "name") String name, @RequestParam(value = "bogy") String body ){
      Human human = hService.findByLogin(login).get(0);
      Article article = new Article();
      article.setAuthor(human);
      article.setName(name);
      article.setBody(body);
      article.setDateAdd(new Timestamp(System.currentTimeMillis()));
      service.save(article);
  }
  //delete!
    @RequestMapping("/article/findone")
    public  Article findOne(int id){
     return service.findOne(id);
    }

    @RequestMapping("/articles/all")
    public Iterable<Article> findAll(){return  service.findAll();}
}
