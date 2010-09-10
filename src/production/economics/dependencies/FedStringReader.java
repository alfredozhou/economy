package economics.dependencies;

import org.springframework.stereotype.*;

import java.io.*;
import java.net.*;

/**
* Date: Sep 10, 2010
* Time: 12:31:32 PM
*/
@Component
public class FedStringReader {
   public String readStringFromFed(String url) throws IOException {
      BufferedReader reader = talkToFed(url);
      return readFromFed(reader);
   }

   private BufferedReader talkToFed(String urlString) throws IOException {
      URL url = new URL(urlString);
      URLConnection uc = url.openConnection();
      InputStream inputStream = uc.getInputStream();
      return new BufferedReader(new InputStreamReader(inputStream));
   }


   private String readFromFed(BufferedReader reader) throws IOException {
      StringBuffer buffer = new StringBuffer();
      String line;
      while ((line = reader.readLine()) != null) {
         buffer.append(line);
      }
      return buffer.toString();
   }
}
