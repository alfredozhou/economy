package economics.dependencies.schemamigrations;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

/**
 * Date: May 1, 2010
 * Time: 4:56:39 PM
 */
@Repository
public class SqlTasksRunner {
    private RawDatabaseConnection databaseConnection;


    @Autowired
    public SqlTasksRunner(RawDatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void runTasks(List<SqlScript> scripts) {
        for (SqlScript script : scripts) {
            try {
                databaseConnection.runUpdate(script.getSql());
                databaseConnection.runUpdate("UPDATE schema_version set version=" +script.versionNumber());
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
