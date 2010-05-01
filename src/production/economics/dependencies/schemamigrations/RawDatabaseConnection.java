package economics.dependencies.schemamigrations;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.sql.*;

/**
 * Date: May 1, 2010
 * Time: 2:26:32 PM
 */
@Repository
public class RawDatabaseConnection {
   private Connection connection;
   private String driverName;
   private String url;
   private String username;
   private String password;

   @Autowired
   public RawDatabaseConnection(DatabaseProperties dbProperties) {
      driverName = dbProperties.driverName();
      url = dbProperties.url();
      username = dbProperties.userName();
      password = dbProperties.password();
      connection = createARawDatabaseConnection();
   }

   private Connection createARawDatabaseConnection() {
      try {
         Class.forName(driverName);
         return DriverManager.getConnection(url, username, password);
      } catch (ClassNotFoundException e) {
         throw new RuntimeException(e);
      } catch (SQLException  e) {
         throw new RuntimeException(e);
      }
   }

   public Integer runQuery(String sql, String columnName) throws SQLException {
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery(sql);
      Integer value = resultSet.getInt(columnName);
      resultSet.close();
      statement.close();
      return value;
   }

   public boolean runUpdate(String sql) throws SQLException {
      Statement statement = connection.createStatement();
      statement.execute(sql);
      statement.close();
      return true;
   }
}
