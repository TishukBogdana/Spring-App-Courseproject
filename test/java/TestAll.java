import com.sun.org.apache.bcel.internal.generic.NEW;
import ifmo.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public class TestAll extends Assert {
    ApplicationContext context;
    TestArticleDAO testArt = new TestArticleDAO();
  TestHumanDAO testHum = new TestHumanDAO();
  TestSeriesDAO testSer = new TestSeriesDAO();
  TestPersonDAO testPerson = new TestPersonDAO();
  TestNewsDAO testNews = new TestNewsDAO();
  TestCommentOnArticleDAO testComArt = new TestCommentOnArticleDAO();
  TestCommentOnNewsDAO testComNews = new TestCommentOnNewsDAO();
  TestCommentOnSeriesDAO testComSer =new TestCommentOnSeriesDAO();
  TestCommentOnTVSeriesDAO testComTV = new TestCommentOnTVSeriesDAO();
    @Before
    public void init(){
        context = new AnnotationConfigApplicationContext(DataConfig.class);
        testArt.init(context);
        testHum.init(context);
        testSer.init(context);
        testPerson.init(context);
        testNews.init(context);
        testComArt.init(context);
        testComNews.init(context);
        testComSer.init(context);
        testComTV.init(context);
    }
    @Test
    public void testArticle(){
        Human human  = new Human(1,"ANON","ANONIM","ANONIMOUS","QWERTY");
       testArt.testFindByName("ARTICLE",2);
     testArt.testFindByAuthor(human,2);
      Timestamp stamp =  testArt.serv.findOne(1).getDateAdd();
       testArt.testFindByDateIsAfter(stamp,0);
       stamp = new Timestamp(System.currentTimeMillis());
       testArt.testFindByDateIsBefore(stamp, 0);
       testArt.testFindByNameAndAuthor("ARTICLE",human, 2);
       Article article = new Article();
       article.setName("test");
       article.setBody("test_case");
       article.setAuthor(human);
       article.setDateAdd(new Timestamp(System.currentTimeMillis()));
        testArt.testSave(article);
       testArt.restRemoveByName("test");
        Human human2  = new Human(2,"ANON1","ANONIM1","ANONIMOUS1","QWERTY1");
       testArt.restRemoveByAuthor(human2);
    }

    @Test
    public void testHuman(){
        testHum.testFindByName("ANON12",1);
        testHum.testFindBySurname("ANONIM12",1);
        testHum.testFindByLogin("ANONIMOUS",1);
        testHum.testFindByNameAndSurname("ANON","ANONIM",1);
        testHum.testRemoveByLogin("VASYA01");
        Human human= new Human();
        human.setName("VASYA");
        human.setSurname("PETROV");
        human.setLogin("VASYA01");
        human.setPassword("qwerty");
        testHum.testSave(human);
    }
    @Test
    public  void testSeries(){

        testSer.testFindByName("SERIA",1);
        testSer.testRemoveByName("SERIA");
        Series series = new Series();
        series.setName("SERIA");
        series.setPlot("something about");
        testSer.testSave(series);

    }
    @Test
    public  void testPerson(){
        Person person = new Person();
        person.setName("HERO");
        person.setSurname("SURNAME HERO");
        person.setDescription("Positive");
        testPerson.testSave(person);
        testPerson.testFindByNameAndSurname("HERO", "SURNAME HERO", 1);
        testPerson.testRemoveByNameAndSurname("HERO", "SURNAME HERO");

    }
    @Test
    public void testNews(){
        News news = new News();
        news.setName("NEWS");
        news.setBody("something interesting or not");
        news.setDateAdd(new Timestamp(System.currentTimeMillis()));
        testNews.testSave(news);
        testNews.testFindByName("NEWS",1);
       testNews.testRemoveByName("NEWS");


       List<News> list =(List<News>)testNews.serv.findAll();
       Timestamp stamp =list.get(0).getDateAdd();
        testNews.testFindByDateIsAfter(stamp,0);
        testNews.testFindByDateIsBefore(new Timestamp(System.currentTimeMillis()),0);
        News news1 = list.get(1);
        testNews.testRemoveByDateIsBefore(news1.getDateAdd());
        testNews.serv.save(news1);
    }
    @Test
    public void testCommentOnArticle(){
       List<CommentOnArticle> list = (List<CommentOnArticle>)testComArt.serv.findAll();
       Article article = list.get(list.size()-1).getArticle();
       Human author = list.get(list.size()-1).getAuthor();
  testComArt.testFindByArticle(article,1);
      testComArt.testFindByAuthor(author,1);
      testComArt.testRemoveByArticle(article);
      testComArt.testRemoveByAuthor(author);

        CommentOnArticle com1 = new CommentOnArticle();
        com1.setArticle(article);
        com1.setAuthor(author);
        com1.setContent("Comment to article");
        com1.setDateAdd(new Timestamp(System.currentTimeMillis()));
       testComArt.testSave(com1);


    }
    @Test
    public void testCommentOnNews(){
        List<CommentOnNews> list = (List<CommentOnNews>)testComNews.serv.findAll();
       News news = list.get(list.size()-1).getNews();
        Human author = list.get(list.size()-1).getAuthor();
      testComNews.testFindByNews(news,1);
      testComNews.testFindByAuthor(author,1);
        testComNews.testRemoveByNews(news);
        testComNews.testRemoveByAuthor(author);

        CommentOnNews com1 = new CommentOnNews();
        com1.setNews(news);
        com1.setAuthor(author);
        com1.setContent("Comment to news");
        com1.setDateAdd(new Timestamp(System.currentTimeMillis()));
        testComNews.testSave(com1);


    }
    @Test
    public void testCommentOnSeries(){
        List<CommentOnSeries> list = (List<CommentOnSeries>)testComSer.serv.findAll();
        Series series = list.get(list.size()-1).getSeries();
        Human author = list.get(list.size()-1).getAuthor();
        testComSer.testFindBySeries(series,1);
        testComSer.testFindByAuthor(author,1);
        testComSer.testRemoveByNews(series);
        testComSer.testRemoveByAuthor(author);

        CommentOnSeries com1 = new CommentOnSeries();
        com1.setSeries(series);
        com1.setAuthor(author);
        com1.setContent("Comment to Seria");
        com1.setDateAdd(new Timestamp(System.currentTimeMillis()));
        testComSer.testSave(com1);
        testComSer.testSave(com1);
    }
    @Test
    public void testCommentOnTVSeries(){
        List<CommentOnTvSeries> list = (List<CommentOnTvSeries>)testComTV.serv.findAll();
        Human author = list.get(list.size()-1).getAuthor();
        testComTV.testFindByAuthor(author,1);
        testComTV.testRemoveByAuthor(author);

        CommentOnTvSeries com1 = new CommentOnTvSeries();
        com1.setAuthor(author);
        com1.setContent("Comment to Serial");
        com1.setDateAdd(new Timestamp(System.currentTimeMillis()));
        testComTV.testSave(com1);

    }
}
