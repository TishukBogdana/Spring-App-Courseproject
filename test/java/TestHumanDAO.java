import ifmo.Human;
import ifmo.HumanServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import java.util.List;

/**
 * Created by Богдана on 13.11.2017.
 */
public class TestHumanDAO extends Assert {
    HumanServiceImpl serv;
    @Before
    public void init(ApplicationContext context){
     serv=   context.getBean(HumanServiceImpl.class);
    }
    @Test
    public void testFindByName(String name, int exp){
        List<Human> list = serv.findByName(name);
        assertEquals(exp, list.size());
    }
    @Test
    public void testFindBySurname(String surname, int exp){
        List<Human> list = serv.findBySurname(surname);
        assertEquals(exp, list.size());
    }
    @Test
    public void testFindByNameAndSurname(String name, String surname, int exp){
        List<Human> list = serv.findByNameAndSurname(name,surname);
        assertEquals(exp, list.size());
    }
    @Test
    public void testFindByLogin(String login, int exp){
        List<Human> list = serv.findByLogin(login);
        assertEquals(exp, list.size());
    }
    @Test
    public void testRemoveByLogin(String login){
        serv.removeByLogin(login);
        List<Human> list = serv.findByLogin(login);
        assertEquals(0, list.size());
    }
    @Test
    public void testSave(Human human){
        serv.save(human);
        human =serv.findOne(human.getIdHuman());
        assertNotNull(human);
    }
}
