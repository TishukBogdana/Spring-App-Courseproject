import ifmo.Series;
import ifmo.SeriesServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by Богдана on 14.11.2017.
 */
public class TestSeriesDAO extends Assert {
    SeriesServiceImpl serv;
    @Before
    public void init(ApplicationContext context){
        serv=context.getBean(SeriesServiceImpl.class);
    }
    @Test
    public void testSave(Series series){
        serv.save(series);
       series =serv.findOne(series.getIdSeries());
       assertNotNull(series);
    }
    @Test
    public void testFindByName(String name,int exp){
        List<Series> list =serv.findByName(name);
        assertEquals(exp, list.size());
    }

    @Test
    public void testRemoveByName(String name){
        serv.removeByName(name);
        assertEquals(0,serv.findByName(name).size());
    }
    @Test
    public void testUpdateSeries(String name, String descr, String prevName){
        Series before = serv.findByName(prevName).get(0);
        serv.updateSeries(name, descr, prevName);
        Series after = serv.findByName(name).get(0);
        assertNotEquals(before, after);
    }
}
