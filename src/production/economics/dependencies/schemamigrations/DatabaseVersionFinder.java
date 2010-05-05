package economics.dependencies.schemamigrations;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.sql.*;

/**
 * Date: May 1, 2010
 * Time: 1:45:00 PM
 */
@Repository
public class DatabaseVersionFinder {
   private RawDatabaseConnection rawConnection;

   @Autowired
   public DatabaseVersionFinder(RawDatabaseConnection rawConnection) {
      this.rawConnection = rawConnection;
   }

   public Integer findCurrentVersion() {
      try {
         return rawConnection.runQuery("select version from schema_version", "version");
      } catch (SQLException e) {
         String message = e.getMessage();
         if (message.toLowerCase().contains("does not exist")) {
            boolean createdTable = runUpdates("create table schema_version (version integer)");
            boolean insertedValue = runUpdates("insert into  schema_version (version) values (0)");
            if (createdTable && insertedValue)
               return 0;
         }
         throw new RuntimeException(e);
      }
   }

   private boolean runUpdates(String sql)  {
      try {
         return rawConnection.runUpdate(sql);
      } catch (SQLException e) {
         throw new RuntimeException(e);
      }
   }

}
