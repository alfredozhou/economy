package economics.controller;

import economics.*;
import economics.dependencies.*;
import org.mockito.*;

/**
 * Date: Apr 29, 2010
 * Time: 1:07:15 PM
 */
public class GDPRepositoryTest extends MockitoTestCase {
   @Mock
   private DatabaseSessionCreator database;
   @Mock
   private FedObservationFetcher fedObservationFetcher;

   public void testPullGDPFromFedWillStoreData() throws Exception {
      InOrder order = Mockito.inOrder(fedObservationFetcher, database);
      GDPRepository repository = new GDPRepository(database, fedObservationFetcher);
      repository.saveGdpIntoDatabase();

      order.verify(fedObservationFetcher).getValuesFromFed(KeysToFedNumbers.GDP);
      order.verify(database).save(Mockito.anyList());
   }
}
