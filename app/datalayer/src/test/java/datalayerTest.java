import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class datalayerTest {
    private Datalayer datalayer;
    private User user;
    private User dbUser;
    @Test
    public void testDatalayer(){
        Datalayer datalayer = new Datalayer();
        assertNotNull(datalayer);
    }

    @Test
    public void testPersist() {
        try {
            datalayer.persist(user);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void testFind() throws Exception {
        User newUser = datalayer.find(dbUser.getUsername());
        assertEquals(dbUser.getId(), newUser.getId());
        assertEquals(dbUser.getUsername(), newUser.getUsername());
    }

    @Before
    public void setup(){
        datalayer = new Datalayer();
        user = new User();
        user.setUsername("DAVID");
        user.setId(2);
        dbUser = new User();
        dbUser.setId(1);
        dbUser.setUsername("ERIKSDAV");
    }
}
