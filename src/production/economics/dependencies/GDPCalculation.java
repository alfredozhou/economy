package economics.dependencies;

import com.google.common.base.*;
import com.google.common.collect.*;
import economics.model.*;
import org.joda.time.*;

import java.math.*;
import java.util.*;

/**
 * Date: Sep 10, 2010
 * Time: 2:24:36 PM
 */
public class GDPCalculation {
   private BigDecimal value = new BigDecimal(0);
   private String desiredDate;

   private GDPCalculation(DateTime today) {
      int year = today.get(DateTimeFieldType.year());
      desiredDate = year + "-01-01";
   }

   public static GDPCalculation gdpIs(DateTime date) {
      return new GDPCalculation(date);
   }

   private BigDecimal find(List<Observation> observations) {
      Observation desiredObservation = Iterables.find(observations, new Predicate<Observation>() {
         public boolean apply(@Nullable Observation observation) {
            String dateString = observation.getDate();
            return dateString.equals(desiredDate);
         }
      });
      return getBigDecimal(desiredObservation.getValue());
   }

   private BigDecimal getBigDecimal(String desiredValue) {
      BigDecimal bigDecimal;
      try {
         bigDecimal = new BigDecimal(desiredValue);
      } catch (NumberFormatException e) {
         bigDecimal = new BigDecimal(0);
      }
      return bigDecimal;
   }

   public GDPCalculation plus(List<Observation> observations) {
      value = value.add(find(observations));
      return this;
   }

   public GDPCalculation minus(List<Observation> observations) {
      value = value.subtract(find(observations));
      return this;
   }

   public GDPCalculation times(List<Observation> deflator) {
      BigDecimal deflatorValue = new BigDecimal("100.00").divide(find(deflator), 3, RoundingMode.HALF_UP);
      value = value.multiply(deflatorValue);
      return this;
   }

   public BigDecimal calculate() {
      return value;
   }
}
