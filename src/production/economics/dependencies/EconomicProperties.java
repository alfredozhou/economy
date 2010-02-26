package economics.dependencies;

import org.springframework.stereotype.Repository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.Properties;

@Repository
public class EconomicProperties extends Properties {
    public EconomicProperties() throws IOException {
        this(new File("economy.properties"));
    }

    public EconomicProperties(File propertyFile) throws IOException {
        load(new FileInputStream(propertyFile));
    }

    public String getUrlForGdp() {
        return super.getProperty("queryForGdpValues");
    }
}
