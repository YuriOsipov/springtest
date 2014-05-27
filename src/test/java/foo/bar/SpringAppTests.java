package foo.bar;

import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class SpringAppTests {
    @Autowired
    private EventStore eventStore;
    @Autowired
    private Event first;
    @Autowired
    private Event second;

    @Test
    public void testSayHello() {

        eventStore.addEvent(first);
        eventStore.addEvent(second);
        Assert.assertEquals( Arrays.asList(new Event[]{first,second}) , eventStore.getEventByAttender("111@mail.ua"));
    }
}
