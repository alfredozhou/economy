package economics.dependencies.schemamigrations;

import java.io.*;
import java.util.regex.*;

/**
 * Date: May 1, 2010
 * Time: 1:21:03 PM
 */
public class SqlScript implements Comparable<SqlScript> {
    private File sqlFile;
    private Pattern sqlFilePattern;

    public SqlScript(File sqlFile) {
        this.sqlFile = sqlFile;
        sqlFilePattern = Pattern.compile("(\\d+)\\.sql");
    }

    public Integer versionNumber() {
        String fileName = sqlFile.getName();
        Matcher matcher = sqlFilePattern.matcher(fileName);
        matcher.matches();
        try {
            return Integer.parseInt(matcher.group(1));
        }
        catch (RuntimeException e) {
            return -1;
        }
    }


    public String getSql() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(sqlFile));
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            builder.append(line);
        }
        return builder.toString();
    }

    public int compareTo(SqlScript anotherSqlScript) {
        return versionNumber().compareTo(anotherSqlScript.versionNumber());
    }
}
