package economics.action;

import economics.controller.GDPRepository;
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
    private GDPRepository repository;

    @Autowired
    public DatabaseInitAction(DatabaseMigrator migrator, ScriptFileManager fileManager, GDPRepository repository) {
        this.migrator = migrator;
        this.fileManager = fileManager;
        this.repository = repository;
    }

    @RequestMapping("/db")
    public ModelAndView performAction() throws IOException {
        List<SqlScript> scripts = fileManager.scriptsToExecute();
        migrator.applyChanges();
        repository.saveGdpIntoDatabase();
        return new ModelAndView("database").addObject("sqls", scripts);
    }
}

