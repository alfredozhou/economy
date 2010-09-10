package economics.dependencies;

import com.google.common.base.*;
import com.google.common.collect.*;
import economics.model.*;
import org.joda.time.*;
import org.springframework.stereotype.*;

import java.math.*;
import java.util.*;

/**
 * Date: Sep 10, 2010
 * Time: 5:31:25 PM
 */
@Component
public class ObservationFinder {
   public BigDecimal find(List<Observation> observations, DateTime date) {
      final String desiredDate = getDesiredDate(date);
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

   private String getDesiredDate(DateTime date) {
      int year = date.get(DateTimeFieldType.year());
      return year + "-01-01";
   }
}
