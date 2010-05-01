package economics.controller;

import economics.dependencies.*;
import economics.model.*;
import org.apache.commons.collections.*;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

/**
 * Date: Apr 29, 2010
 * Time: 12:59:05 PM
 */
@Repository
public class GDPRepository {
   private DatabaseSessionCreator databaseSession;
   private GDPMaker puller;

   @Autowired
   public GDPRepository(DatabaseSessionCreator databaseSession, GDPMaker gdpPuller) {
      this.databaseSession = databaseSession;
      this.puller = gdpPuller;
   }

   public void saveGdpIntoDatabase() {
      List<Observation> gdpPerYear = puller.getGDPsFromFed();
      databaseSession.save(gdpPerYear);    
   }

   public List<Observation> getGdpFromDb() {
      return databaseSession.list(Observation.class);
   }
}
