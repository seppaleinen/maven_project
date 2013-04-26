import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

public class TestSelenium{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 8090, "*chrome", "http://localhost:8090/Maven");
		selenium.start();
	}

	@Test
	public void test() throws Exception {
		selenium.check("userName=null");
        assertNotNull(null);
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
