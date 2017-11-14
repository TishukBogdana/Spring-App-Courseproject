import com.sun.org.apache.bcel.internal.generic.NEW;
import ifmo.News;
import ifmo.NewsServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import sun.applet.AppletListener;

import java.sql.Timestamp;

/**
 * Created by Богдана on 14.11.2017.
 */
public class TestNewsDAO extends Assert {
    NewsServiceImpl serv;
    @Before
    public void init(ApplicationContext context){
        serv =context.getBean(NewsServiceImpl.class);
    }
    @Test
    public void testFindByName(String name, int exp){
        assertEquals(exp, serv.findByName(name).size());
    }
    @Test
    public void testFindByDateIsBefore(Timestamp date, int nexp){
        assertNotEquals(nexp, serv.findByDateAddBefore(date));
    }
    @Test
    public void testFindByDateIsAfter(Timestamp date, int nexp){
        assertNotEquals(nexp, serv.findByDateAddIsAfter(date));
    }
    @Test
    public void testRemoveByDateIsBefore(Timestamp date){
        serv.removeIfDateIsBefore(date);
        assertEquals(0, serv.findByDateAddBefore(date).size());
    }
    @Test
    public void testRemoveByName(String name){
        serv.removeByName(name);
        assertEquals(0, serv.findByName(name).size());
    }
 @Test
    public void testSave(News news){
        serv.save(news);
        assertNotNull(serv.findOne(news.getIdNews()));
 }
}
