import org.dbunit.DatabaseTestCase;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.database.IDatabaseConnection;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;

@RunWith(MockitoJUnitRunner.class)
public class DBUnitTest extends DatabaseTestCase {
    private FlatXmlDataSet loadedDataSet;
    private IDatabaseConnection con;

    @Override
    protected IDatabaseConnection getConnection() throws Exception {
        Class driverClass = Class.forName("com.mysql.jdbc.Driver");
        Connection jdbcConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/maven_db", "root", "");
        return new DatabaseConnection(jdbcConnection);
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        FlatXmlDataSetBuilder builder = new FlatXmlDataSetBuilder();
        InputStream resource = this.getClass().getClassLoader().getResourceAsStream("input.xml");
        loadedDataSet = builder.build(resource);
        return loadedDataSet;
    }
    @Test
    public void testCheckLoginDataLoaded() throws Exception{
        assertNotNull(loadedDataSet);
        int rowCount = loadedDataSet.getTable("user").getRowCount();
        assertEquals(2, rowCount);
    }

    @Before
    public void setup() throws Exception {
        loadedDataSet = (FlatXmlDataSet) getDataSet();
        con = getConnection();
    }
}
