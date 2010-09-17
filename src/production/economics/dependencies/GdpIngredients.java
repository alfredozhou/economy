package economics.dependencies;

import economics.controller.*;
import economics.model.*;
import org.joda.time.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

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
   private ObservationFinder finder;

   @Autowired
   public GdpIngredients(FedObservationFetcher observationFetcher, ObservationFinder finder) {
      this.observationFetcher = observationFetcher;
      this.finder = finder;
      allDataFromFed();
   }

   private void allDataFromFed() {
      government = observationFetcher.getValuesFromFed(KeysToFedNumbers.government);
      business = observationFetcher.getValuesFromFed(KeysToFedNumbers.business);
      deflator = observationFetcher.getValuesFromFed(KeysToFedNumbers.deflator);
      personalConsumption = observationFetcher.getValuesFromFed(KeysToFedNumbers.personalConsumption);
      residential = observationFetcher.getValuesFromFed(KeysToFedNumbers.residential);
      imports = observationFetcher.getValuesFromFed(KeysToFedNumbers.imports);
      exports = observationFetcher.getValuesFromFed(KeysToFedNumbers.exports);
   }

   public GdpComponent get(DateTime date) {
      BigDecimal consumption = finder.find(personalConsumption, date);
      BigDecimal govt = finder.find(government, date);
      BigDecimal biz = finder.find(business, date);
      BigDecimal residencial = finder.find(residential, date);
      BigDecimal exportts = finder.find(exports, date);
      BigDecimal importsd = finder.find(imports, date);
      BigDecimal deflate = finder.find(deflator, date);
      return new GdpComponent(consumption, govt, biz, residencial, exportts, importsd, deflate);
   }

}
