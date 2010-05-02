package economics.dependencies.schemamigrations;

import economics.MockitoTestCase;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.List;

import static java.util.Arrays.asList;
import static org.mockito.Mockito.when;

public class SqlTasksRunnerTest extends MockitoTestCase {
    @Mock
    private RawDatabaseConnection connection;
    @Mock
    private SqlScript script;

    public void testUpdatesTheDbVersion() throws Exception {
        SqlTasksRunner tasksRunner = new SqlTasksRunner(connection);
        tasksRunner.runTasks(mockScripts());
        Mockito.verify(connection).runUpdate("update something");
        Mockito.verify(connection).runUpdate("UPDATE schema_version set version=2");
    }

    private List<SqlScript> mockScripts() throws IOException {
        when(script.versionNumber()).thenReturn(2);
        when(script.getSql()).thenReturn("update something");
        return asList(script);
    }
}