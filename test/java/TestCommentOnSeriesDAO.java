import ifmo.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

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
}
