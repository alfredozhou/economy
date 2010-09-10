package economics.controller;

import economics.dependencies.*;
import economics.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Date: Apr 29, 2010
 * Time: 12:59:05 PM
 */
@Component
public class GDPRepository {
   private DatabaseSessionCreator databaseSession;
   private FedObservationFetcher puller;

   @Autowired
   public GDPRepository(DatabaseSessionCreator databaseSession, FedObservationFetcher gdpPuller) {
      this.databaseSession = databaseSession;
      this.puller = gdpPuller;
   }

   public void saveGdpIntoDatabase() {
      List<Observation> gdpPerYear = puller.getValuesFromFed(KeysToFedNumbers.GDP);
      databaseSession.save(gdpPerYear);    
   }

   public List<Observation> getGdpFromDb() {
      return databaseSession.list(Observation.class);
   }
}
