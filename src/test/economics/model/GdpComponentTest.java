package economics.model;

import economics.*;
import org.mockito.*;

import java.math.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Date: Sep 10, 2010
 * Time: 5:39:11 PM
 */
public class GdpComponentTest extends MockitoTestCase {

   private BigDecimal personalConsumption= new BigDecimal("5");
   private BigDecimal governmentExpenditure= new BigDecimal("4");
   private BigDecimal businessInvestment= new BigDecimal("3");
   private BigDecimal residentialInvestment= new BigDecimal("2");
   private BigDecimal exports= new BigDecimal("2");
   private BigDecimal imports= new BigDecimal("1");
   private BigDecimal deflator= new BigDecimal("80");

   @Override
   protected void setUp() throws Exception {
      super.setUp();
   }

   public void testCalculateGdp() throws Exception {
      BigDecimal value = new GdpComponent(
            personalConsumption,
            governmentExpenditure,
            businessInvestment,
            residentialInvestment,
            exports,
            imports,
            deflator).calculate();
      assertThat(value, equalTo(new BigDecimal("18.750")));
   }


}
