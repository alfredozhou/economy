package economics.dependencies.schemamigrations;

import org.springframework.stereotype.*;

/**
 * Date: May 1, 2010
 * Time: 5:34:21 PM
 */
@Repository
public class DatabaseProperties {
   public String driverName() {
      return "org.sqlite.JDBC";
   }

   public String url() {
      return "jdbc:sqlite:1.db";
   }

   public String userName() {
      return "sa";
   }

   public String password() {
      return "";
   }
}
