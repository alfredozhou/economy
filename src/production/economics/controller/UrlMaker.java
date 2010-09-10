package economics.controller;

import economics.dependencies.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

/**
* Date: Sep 10, 2010
* Time: 12:07:50 PM
*/
@Component
public class UrlMaker {
   private EconomicProperties properties;

   private String fedUrl = "http://api.stlouisfed.org/fred/series/observations?series_id=";
   private String apiKey = "&api_key=";
   @Autowired
   public UrlMaker(EconomicProperties properties) {
      this.properties = properties;
   }

   public String constructUrl(KeysToFedNumbers key) {
      String apiKeyForFed = properties.getApiKeyForFed();
      return fedUrl + key.getSeriesName() + apiKey + apiKeyForFed;
   }
}
