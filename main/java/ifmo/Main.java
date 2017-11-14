package ifmo;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 12.11.2017.
 */


public class Main {

    public static void main(String[] args){
        ApplicationContext context = new AnnotationConfigApplicationContext(DataConfig.class);
      ArticleRepo serv = context.getBean(ArticleRepo.class);
        System.out.println("Hello!");
        Human human  = new Human(3,"ANON12","ANONIM12","ANONIMOUS12","QWERTY12");
       // serv.removeByName("ARTICL");
     //   serv.update("ARTICLE12",human, "UPDATED-name", "updated+body", new Timestamp(System.currentTimeMillis()));
        List<Article> list = serv.findByAuthor(human);
        System.out.print(list.get(0).getName());
    }
}