package economics.dependencies.schemamigrations;

import org.springframework.stereotype.*;

/**
 * Date: May 1, 2010
 * Time: 5:34:21 PM
 */
@Repository
public class DatabaseProperties {
   public String driverName() {
      return "org.apache.derby.jdbc.EmbeddedDriver";
   }

   public String url() {
      return "jdbc:derby:database/derbyeconomy;create=true";
   }

   public String userName() {
      return "";
   }

   public String password() {
      return "";
   }
}
