package economics.dependencies.schemamigrations;

import com.google.common.base.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

import static com.google.common.collect.Iterables.filter;
import static com.google.common.collect.Lists.transform;
import static com.google.common.collect.Ordering.natural;
import static java.util.Arrays.asList;

/**
 * Date: May 1, 2010
 * Time: 3:18:55 PM
 */
@Repository
public class ScriptFileManager {
   private File scriptFolder;
   private DatabaseVersionFinder dbVersionFinder;

   @Autowired
   public ScriptFileManager(DatabaseVersionFinder dbVersionFinder) {
      this(new File("web/WEB-INF/resources/database"), dbVersionFinder);
   }

   ScriptFileManager(File scriptFolder, DatabaseVersionFinder dbVersionFinder) {
      this.scriptFolder = scriptFolder;
      this.dbVersionFinder = dbVersionFinder;
   }

   public List<SqlScript> scriptsToExecute() {
      Integer lastDBVersionNumber = dbVersionFinder.findCurrentVersion();
      Iterable<SqlScript> sqlFiles = transform(allSqlFiles(), toSqlScript());
      Iterable<SqlScript> sqlScripts = filter(sqlFiles, isGreaterThanDbVersion(lastDBVersionNumber));
      return natural().sortedCopy(sqlScripts);
   }

   private Function<File, SqlScript> toSqlScript() {
      return new Function<File, SqlScript>() {
         public SqlScript apply(@Nullable File file) {
            return new SqlScript(file);
         }
      };
   }

   private Predicate<SqlScript> isGreaterThanDbVersion(final Integer dbVersion) {
      return new Predicate<SqlScript>() {
         public boolean apply(@Nullable SqlScript sqlScript) {
            return sqlScript.versionNumber() > dbVersion;
         }
      };
   }

   private List<File> allSqlFiles() {
      return asList(scriptFolder.listFiles(new FilenameFilter() {
         public boolean accept(File dir, String name) {
            return name.endsWith(".sql");
         }
      }));
   }
}
