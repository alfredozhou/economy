package economics.dependencies;

import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

@Component
public class EconomicProperties extends Properties {
   public EconomicProperties() throws IOException {
      this(new File("economy.properties"));
   }

   public EconomicProperties(File propertyFile) throws IOException {
      load(new FileInputStream(propertyFile));
   }

   public String getApiKeyForFed() {
      return super.getProperty("fredAPIKey");
   }

}
