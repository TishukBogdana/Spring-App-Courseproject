
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import ru.ifmo.cs.domain.CommentOnSeries;
import ru.ifmo.cs.servimplementations.CommentOnSeriesServiceImpl;
import ru.ifmo.cs.domain.Human;
import ru.ifmo.cs.domain.Series;

import java.sql.Timestamp;

/**
 * Created by Богдана on 14.11.2017.
 */
public class TestCommentOnSeriesDAO extends Assert {
    CommentOnSeriesServiceImpl serv ;
    @Before
    public void init(ApplicationContext context){
        serv=context.getBean(CommentOnSeriesServiceImpl.class);
    }
    @Test
    public void testFindByAuthor(Human author, int exp){
        assertEquals(exp, serv.findByAuthor(author).size());
    }
    @Test
    public void testFindBySeries(Series series, int exp){
        assertEquals(exp, serv.findBySeries(series).size());
    }
    @Test
    public void testRemoveByAuthor(Human author){
        serv.removeByAuthor(author);
        assertEquals(0,serv.findByAuthor(author).size());
    }
    @Test
    public void testRemoveByNews(Series series){
        serv.removeBySeries(series);
        assertEquals(0,serv.findBySeries(series).size());
    }
    @Test
    public void testSave(CommentOnSeries comment){
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
