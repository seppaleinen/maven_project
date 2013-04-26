import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriverCommandProcessor;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertTrue;

public class TestSelenium{
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
        selenium = new DefaultSelenium(new WebDriverCommandProcessor("http://localhost:4444", new FirefoxDriver()));
        selenium.open("/Maven");
	}

	@Test
	public void test() throws Exception {
        assertTrue(selenium.isTextPresent("Username"));
	}

	@After
	public void tearDown() throws Exception {
		selenium.close();
	}
}
