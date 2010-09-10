package economics.controller;

import economics.dependencies.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;

@Component
public class MessagePuller {
   private UrlMaker urlMaker;
   private FedStringReader stringReader;
   
   @Autowired
   public MessagePuller(UrlMaker urlMaker, FedStringReader stringReader) {
      this.urlMaker = urlMaker;
      this.stringReader = stringReader;
   }

   public String pullMessageFromFed(KeysToFedNumbers fedSeriesName) throws IOException {
      String url = urlMaker.constructUrl(fedSeriesName);
      return stringReader.readStringFromFed(url);
   }
}
