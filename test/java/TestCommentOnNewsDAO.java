import com.sun.org.apache.bcel.internal.generic.NEW;
import ifmo.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.sql.Timestamp;

/**
 * Created by Богдана on 14.11.2017.
 */
public class TestCommentOnNewsDAO extends Assert {
    CommentOnNewsServiceImpl serv ;
    @Before
    public void init(ApplicationContext context){
        serv= context.getBean(CommentOnNewsServiceImpl.class);
    }
    @Test
    public void testFindByAuthor(Human author, int exp){
        assertEquals(exp, serv.findByAuthor(author).size());
    }
    @Test
    public void testFindByNews(News news, int exp){
        assertEquals(exp, serv.findByNews(news).size());
    }
    @Test
    public void testRemoveByAuthor(Human author){
        serv.removeByAuthor(author);
        assertEquals(0,serv.findByAuthor(author).size());
    }
    @Test
    public void testRemoveByNews(News news){
        serv.removeByNews(news);
        assertEquals(0,serv.findByNews(news).size());
    }
    @Test
    public void testSave(CommentOnNews comment){
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
