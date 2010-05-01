package economics.action;

import economics.dependencies.schemamigrations.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;

import java.io.*;
import java.util.*;

/**
 * Date: May 1, 2010
 * Time: 12:57:27 PM
 */
@Controller
public class DatabaseInitAction {
   private DatabaseMigrator migrator;
   private ScriptFileManager fileManager;

   @Autowired
   public DatabaseInitAction(DatabaseMigrator migrator, ScriptFileManager fileManager) {
      this.migrator = migrator;
      this.fileManager = fileManager;
   }

   @RequestMapping("/db")
   public ModelAndView performAction() throws IOException {
      List<SqlScript> scripts = fileManager.scriptsToExecute();
      migrator.applyChanges();
      return new ModelAndView("database").addObject("sqls", scripts);
   }
}

