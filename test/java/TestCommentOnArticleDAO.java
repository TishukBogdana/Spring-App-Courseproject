import ifmo.Article;
import ifmo.CommentOnArticle;
import ifmo.CommentOnArticleServiceImpl;
import ifmo.Human;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;

/**
 * Created by Богдана on 14.11.2017.
 */
public class TestCommentOnArticleDAO extends Assert {
    CommentOnArticleServiceImpl serv ;
    @Before
    public void init(ApplicationContext context){
        serv = context.getBean(CommentOnArticleServiceImpl.class);
    }
    @Test
    public void testFindByAuthor(Human author, int exp){
        assertEquals(exp, serv.findByAuthor(author).size());
    }
  @Test
  public void testFindByArticle(Article article, int exp){
        assertEquals(exp, serv.findByArticle(article).size());
  }
    @Test
    public void testRemoveByAuthor(Human author){
        serv.removeByAuthor(author);
        assertEquals(0,serv.findByAuthor(author).size());
    }
    @Test
    public void testRemoveByArticle(Article article){
        serv.removeByArticle(article);
        assertEquals(0,serv.findByArticle(article).size());
    }
    @Test
    public void testSave(CommentOnArticle comment){
        serv.save(comment);
        assertNotNull(serv.findOne(comment.getId()));
    }
    @Test
    public void testUpdateComment(String content, Timestamp stamp, int id){
        Timestamp before = serv.findOne(id).getDateAdd();
        serv.updateComment(content,stamp,id);
        Timestamp after = serv.findOne(id).getDateAdd();
        assertNotEquals(before, after);
    }
}
