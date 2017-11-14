import ifmo.CommentOnTVSeriesImpl;
import ifmo.CommentOnTvSeries;
import ifmo.Human;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * Created by Богдана on 14.11.2017.
 */
public class TestCommentOnTVSeriesDAO extends Assert {
    CommentOnTVSeriesImpl serv;
    @Before
    public void init(ApplicationContext context){
        serv = context.getBean(CommentOnTVSeriesImpl.class);
    }
    @Test
    public void testFindByAuthor(Human author, int exp){
        assertEquals(exp, serv.findByAuthor(author).size());
    }

    @Test
    public void testRemoveByAuthor(Human author){
        serv.removeByAuthor(author);
        assertEquals(0,serv.findByAuthor(author).size());
    }


    @Test
    public void testSave(CommentOnTvSeries comment){
        serv.save(comment);
        assertNotNull(serv.findOne(comment.getId()));
    }
}
