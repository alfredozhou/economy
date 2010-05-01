package economics.dependencies.schemamigrations;

import org.junit.*;

import java.sql.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Date: May 1, 2010
 * Time: 1:50:43 PM
 */
public class DatabaseVersionFinderTest {
   private RawDatabaseConnection connectionMaker = new RawDatabaseConnection(new DatabaseProperties());

   @Before
   public void deleteVersionTable()  {
      try {
         connectionMaker.runUpdate("drop table schema_version");
      } catch (SQLException e) {
         //its ok if there is no table when the test is starting
      }
   }

   @After
   public void deleteVersionTable2() throws SQLException {
      connectionMaker.runUpdate("drop table schema_version");
   }

   @Test
   public void createsSchemaVersionTableIfOneDoesntExist() {
      DatabaseVersionFinder finder = new DatabaseVersionFinder(connectionMaker);
      assertThat(finder.findCurrentVersion(), equalTo(0));
   }

   @Test
   public void testCanRetrieveValue() throws Exception {
      seedSchemaVersionWith5();
      DatabaseVersionFinder finder = new DatabaseVersionFinder(connectionMaker);
      assertThat(finder.findCurrentVersion(), equalTo(5));
   }

   private void seedSchemaVersionWith5() throws SQLException {
      connectionMaker.runUpdate("create table schema_version (version integer);");
      connectionMaker.runUpdate("insert into  schema_version (version) values (5);");
   }
}
