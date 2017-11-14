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
      ArticleServiceImpl serv = context.getBean(ArticleServiceImpl.class);
        System.out.println("Hello!");
        Human human  = new Human(1,"ANON","ANONIM","ANONIMOUS","QWERTY");
       // serv.removeByName("ARTICL");
        List<Article> list = serv.findByAuthor(human);
        System.out.print(list.get(0).getName());
    }
}
