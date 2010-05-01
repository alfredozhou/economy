package economics.dependencies.schemamigrations;

import org.apache.tools.ant.*;
import org.apache.tools.ant.taskdefs.*;

/**
 * Date: May 1, 2010
 * Time: 1:18:55 PM
 */

public class SqlExecutor extends SQLExec {
   public SqlExecutor() {
      Project project = new Project();
      setProject(project);
      project.init();
      setTaskType("sql");
      setTaskName("sql");
      setOwningTarget(new Target());
   }

}
