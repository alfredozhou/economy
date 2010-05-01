package economics.dependencies.schemamigrations;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Date: May 1, 2010
 * Time: 4:56:39 PM
 */
@Repository
public class SqlTasksRunner {
   private DatabaseProperties dbProperties;

   @Autowired
   public SqlTasksRunner(DatabaseProperties properties) {
      this.dbProperties = properties;
   }

   public void runTasks(List<SqlScript> scripts) {
      SqlExecutor sqlExecutor = makeSqlTaskExecutor();
      for (SqlScript script : scripts) {
         addSqlScripts(script, sqlExecutor);
      }
      sqlExecutor.execute();
   }

   private SqlExecutor makeSqlTaskExecutor() {
      SqlExecutor sqlTaskExecutor = new SqlExecutor();
      sqlTaskExecutor.setDriver(dbProperties.driverName());
      sqlTaskExecutor.setUrl(dbProperties.url());
      sqlTaskExecutor.setUserid(dbProperties.userName());
      sqlTaskExecutor.setPassword(dbProperties.password());
      return sqlTaskExecutor;
   }

   private void addSqlScripts(SqlScript sqlTask, SqlExecutor executor) {
      executor.createTransaction().setSrc(sqlTask.getSqlFile());
      executor.createTransaction().addText("UPDATE schema_version set version='" + sqlTask.versionNumber() + "'");
   }
}
