import ifmo.Person;
import ifmo.PersonServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * Created by Богдана on 14.11.2017.
 */
public class TestPersonDAO extends Assert {
    PersonServiceImpl serv;
    @Before
    public void init(ApplicationContext context){
        serv = context.getBean(PersonServiceImpl.class);
    }
 @Test
 public void testFindByNameAndSurname(String name, String surname, int exp){
        assertEquals(exp, serv.findByNameAndSurname(name, surname).size());
 }
 @Test
    public void testRemoveByNameAndSurname(String name, String surname){
     serv.removeByNameAndSirname(name, surname);
        assertEquals(0, serv.findByNameAndSurname(name, surname).size());
    }
    @Test
    public void testSave(Person person){
        serv.save(person);
        assertNotNull(serv.findOne(person.getIdPerson()));
    }
    @Test
    public void testUpdatePerson(String name,String surname, String descr, String prevName, String prevSurname){
        Person before = serv.findByNameAndSurname(prevName,prevSurname).get(0);
        serv.updatePerson(name, surname, descr,prevName, prevSurname);
        Person after = serv.findByNameAndSurname(name,surname).get(0);
        assertNotEquals(before, after);
    }

}
