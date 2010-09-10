package economics.dependencies;

import economics.*;
import economics.model.*;
import org.joda.time.*;
import org.mockito.*;

import java.math.*;
import java.util.*;

import static economics.dependencies.GDPCalculation.gdpIs;
import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

/**
 * Date: Sep 10, 2010
 * Time: 2:35:30 PM
 */
public class GDPCalculationTest extends MockitoTestCase {
   private DateTime date = new DateTime(2004, 2, 11, 12, 0, 0, 0);
   @Mock
   private Observation wantedObservation, notWantedObservation;
   @Mock
   private Observation wantedDeflator, notWantedDeflator;
   private BigDecimal thousand = new BigDecimal(1000);
   private BigDecimal hundred = new BigDecimal(100);
   private BigDecimal eighty = new BigDecimal(80);

   @Override
   protected void setUp() throws Exception {
      super.setUp();
      when(wantedObservation.getDate()).thenReturn("2004-01-01");
      when(notWantedObservation.getDate()).thenReturn("2001-01-01");
      when(wantedDeflator.getDate()).thenReturn("2004-01-01");
      when(notWantedDeflator.getDate()).thenReturn("2006-01-01");
   }

   public void testCalculateGdp() throws Exception {
      when(wantedObservation.getValue()).thenReturn(thousand);
      when(wantedDeflator.getValue()).thenReturn(eighty);
      BigDecimal value = gdpIs(date)
            .plus(observations())
            .plus(observations())
            .times(deflators())
            .calculate();
      assertThat(value, equalTo(thousand.add(thousand).multiply(hundred.divide(eighty))));
   }

   private List<Observation> deflators() {
      return asList(notWantedDeflator, wantedDeflator);
   }

   private List<Observation> observations() {
      return asList(wantedObservation, notWantedObservation);
   }
}
