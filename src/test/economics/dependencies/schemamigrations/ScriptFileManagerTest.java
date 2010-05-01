package economics.dependencies.schemamigrations;

import com.google.common.collect.*;
import economics.*;
import org.mockito.*;

import java.io.*;
import java.util.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Date: May 1, 2010
 * Time: 4:14:23 PM
 */
public class ScriptFileManagerTest extends MockitoTestCase {
   @Mock
   private File directory;
   @Mock
   private DatabaseVersionFinder dbVersionFinder;

   public void testFindAllTheSqlsByNumber() throws Exception {
      stubFolderWithFilesNamed("1.sql", "2.sql", "3.txt");
      stubCurrentDBVersionToBe(1);
      ScriptFileManager manager = new ScriptFileManager(directory, dbVersionFinder);
      List<SqlScript> sqls = manager.scriptsToExecute();
      assertThat(sqls.size(), equalTo(1));
      assertThat(Iterables.get(sqls, 0).versionNumber(), equalTo(2));
   }

   private void stubCurrentDBVersionToBe(int number) {
      when(dbVersionFinder.findCurrentVersion()).thenReturn(number);
   }

   private void stubFolderWithFilesNamed(String file1, String file2, String file3) {
      File[] files = {new File(file1), new File(file2), new File(file3)};
      when(directory.listFiles(Mockito.<FilenameFilter>any())).thenReturn(files);
   }
}
