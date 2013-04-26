import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestSelenium{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:20080/maven");
		selenium.start();
	}

	@Test
	public void test() throws Exception {
		selenium.check("id=hej");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
