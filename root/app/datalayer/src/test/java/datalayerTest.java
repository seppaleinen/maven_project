import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class datalayerTest {
    @Test
    public void testDatalayer(){
        Datalayer datalayer = new Datalayer();
        assertNotNull(datalayer);
    }

    @Test
    public void testPersist(){
        Datalayer datalayer = new Datalayer();
        datalayer.persist("david");
        assertEquals("david", datalayer.find("david"));
    }
}
