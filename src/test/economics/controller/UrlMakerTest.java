package economics.controller;

import economics.*;
import economics.dependencies.*;
import junit.framework.*;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Date: Sep 10, 2010
 * Time: 12:12:05 PM
 */
public class UrlMakerTest extends MockitoTestCase {
   public void testConstructUrl() throws Exception {
      UrlMaker maker = new UrlMaker(new EconomicProperties());
      String url = maker.constructUrl(KeysToFedNumbers.GDP);
      assertThat(url,
            equalTo("http://api.stlouisfed.org/fred/series/observations?series_id=GDPCA&api_key=6485d1238bb0ddc8c128ac0a2434504f"));

      url = maker.constructUrl(KeysToFedNumbers.government);
      assertThat(url,
                  equalTo("http://api.stlouisfed.org/fred/series/observations?series_id=AFEXPND&api_key=6485d1238bb0ddc8c128ac0a2434504f"));

   }
}
