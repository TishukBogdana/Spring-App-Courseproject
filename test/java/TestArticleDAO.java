import ifmo.Article;
import ifmo.ArticleServiceImpl;
import ifmo.DataConfig;
import ifmo.Human;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public class TestArticleDAO extends Assert {

    ArticleServiceImpl serv;
    @Before
    public void init(ApplicationContext context){

        serv = context.getBean(ArticleServiceImpl.class);
    }
    @Test
    public void testFindByName(String name,  int exp){
        List<Article> list = serv.findByName(name);
        assertNotNull(list);
        assertEquals(exp,list.size());

    }
    @Test
    public void testFindByAuthor(Human human, int exp){
        List<Article> list = serv.findByAuthor(human);
        assertNotNull(list);
        assertEquals(exp, list.size());
    }
    @Test
    public void testFindByDateIsAfter(Timestamp stamp, int nexp){

    List<Article> list = serv.findByDateAddIsAfter(stamp);
    assertNotEquals(nexp, list.size());
    }
    @Test
    public void testFindByDateIsBefore(Timestamp stamp, int nexp){
        List<Article> list = serv.findByDateAddIsBefore(stamp);
        assertNotEquals(nexp, list.size());
    }
    @Test
    public void testFindByNameAndAuthor(String name, Human human, int exp){

        List<Article> list = serv.findByNameAndAuthor(name,human);
        assertEquals(exp,list.size());
    }
    @Test
    public void testSave(Article article){
        serv.save(article);
        article = serv.findOne(article.getIdArticle());
        assertNotNull(article);
    }

    @Test
    public void restRemoveByName(String name){
        serv.removeByName(name);
        List<Article> list = serv.findByName(name);
        assertEquals(0,list.size());
    }
    @Test
    public void restRemoveByAuthor(Human author){
        serv.removeByAuthor(author);
        List<Article> list = serv.findByAuthor(author);
        assertEquals(0,list.size());
    }
@Test
    public void testUpdateByNameAndBody(String prev, Human author, String name, String body, Timestamp stamp){
        List<Article> before = serv.findByNameAndAuthor(prev,author);
    serv.updateByNameAndBody(prev,author, name, body,stamp);
    List<Article>after = serv.findByNameAndAuthor(name,author);
     assertNotEquals(before,after);
}
}
