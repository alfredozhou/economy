package economics.dependencies;

import economics.controller.*;
import economics.model.*;
import org.joda.time.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

import static economics.dependencies.GDPCalculation.gdpIs;

/**
 * Date: Sep 10, 2010
 * Time: 1:34:03 PM
 */
@Component
public class GdpIngredients {
   private List<Observation> government;
   private List<Observation> business;
   private List<Observation> deflator;
   private List<Observation> personalConsumption;
   private List<Observation> residential;
   private List<Observation> imports;
   private List<Observation> exports;
   private FedObservationFetcher observationFetcher;

   @Autowired
   public GdpIngredients(FedObservationFetcher observationFetcher) {
      this.observationFetcher = observationFetcher;
      allDataFromFed();
   }

   public void allDataFromFed() {
      government = observationFetcher.getValuesFromFed(KeysToFedNumbers.government);
      business = observationFetcher.getValuesFromFed(KeysToFedNumbers.business);
      deflator = observationFetcher.getValuesFromFed(KeysToFedNumbers.deflator);
      personalConsumption = observationFetcher.getValuesFromFed(KeysToFedNumbers.personalConsumption);
      residential = observationFetcher.getValuesFromFed(KeysToFedNumbers.residential);
      imports = observationFetcher.getValuesFromFed(KeysToFedNumbers.imports);
      exports = observationFetcher.getValuesFromFed(KeysToFedNumbers.exports);
   }

   public BigDecimal calculate(DateTime today) {
      return gdpIs(today)
            .plus(personalConsumption)
            .plus(government)
            .plus(business)
            .plus(residential)
            .plus(exports)
            .minus(imports)
            .times(deflator)
            .calculate();
   }


}
