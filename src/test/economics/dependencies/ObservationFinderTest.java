package economics.dependencies;

import economics.*;
import economics.model.*;
import org.joda.time.*;
import org.mockito.*;

import java.math.*;
import java.util.*;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Date: Sep 10, 2010
 * Time: 5:53:40 PM
 */
public class ObservationFinderTest extends MockitoTestCase {
   private DateTime date = new DateTime(2004, 2, 11, 12, 0, 0, 0);
   @Mock
   private Observation wantedObservation, notWantedObservation;
   private String thousand = "1000";
   private String eighty = "80";
   private ObservationFinder observationFinder;

   public ObservationFinderTest() {
      observationFinder = new ObservationFinder();
   }

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      when(wantedObservation.getDate()).thenReturn("2004-01-01");
      when(notWantedObservation.getDate()).thenReturn("2001-01-01");
   }

   public void testCalculateGdp() throws Exception {
      when(wantedObservation.getValue()).thenReturn(thousand);
      when(notWantedObservation.getValue()).thenReturn(eighty);
      BigDecimal value = observationFinder.find(observations(), date);
      assertThat(value, equalTo(new BigDecimal("1000")));
   }


   public void testInvalidValues() throws Exception {
      when(wantedObservation.getValue()).thenReturn(".");
      when(notWantedObservation.getValue()).thenReturn(eighty);
      BigDecimal value = observationFinder.find(observations(), date);
      assertThat(value, equalTo(new BigDecimal(0)));
   }

   private List<Observation> observations() {
      return asList(wantedObservation, notWantedObservation);
   }
}
