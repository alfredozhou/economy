package economics.dependencies.schemamigrations;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/**
 * Date: May 1, 2010
 * Time: 12:58:29 PM
 */
@Repository
public class DatabaseMigrator {
   private ScriptFileManager scriptManager;
   private SqlTasksRunner tasksRunner;

   @Autowired
   public DatabaseMigrator(ScriptFileManager scriptManager, SqlTasksRunner tasksRunner) {
      this.scriptManager = scriptManager;
      this.tasksRunner = tasksRunner;
   }

   public void applyChanges() {
      tasksRunner.runTasks(scriptManager.scriptsToExecute());
   }
}
