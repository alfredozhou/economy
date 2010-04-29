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
   private GDPMaker gdpMaker;

   public void testPullGDPFromFedWillStoreData() throws Exception {
      InOrder order = Mockito.inOrder(gdpMaker, database);
      new GDPRepository(database, gdpMaker);
      order.verify(gdpMaker).getGDPsFromFed();
      order.verify(database).save(Mockito.anyList());
   }
}
