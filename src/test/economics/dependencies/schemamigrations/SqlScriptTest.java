package economics.dependencies.schemamigrations;

import economics.*;
import org.hamcrest.*;

import java.io.*;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Date: May 1, 2010
 * Time: 1:24:37 PM
 */
public class SqlScriptTest extends MockitoTestCase {
   public void testCanParseVersionNumber() throws Exception {
      SqlScript script = new SqlScript(new File("1234.sql"));
      assertEquals(new Integer(1234), script.versionNumber());
   }
}
