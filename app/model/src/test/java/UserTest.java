import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class UserTest {
    @Test
    public void testUserConstructor(){
        User user = new User();
        assertNotNull(user);
    }

    @Test
    public void testUserGetters(){
        User user = new User();
        user.setUsername("david");
        String username = user.getUsername();
        assertEquals("david", username);
    }
}
