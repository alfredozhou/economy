package economics.controller;

import economics.dependencies.*;
import economics.model.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.io.*;
import java.util.*;

/**
 * Date: Apr 29, 2010
 * Time: 3:21:27 PM
 */
@Component
public class GDPMaker {
   private MessagePuller pullMessage;
   private XmlToGdpUnmarshaller toObservationsConverter;

   @Autowired
   public GDPMaker(MessagePuller fedStringPuller, XmlToGdpUnmarshaller toObservationsConverter) {
      this.pullMessage = fedStringPuller;
      this.toObservationsConverter = toObservationsConverter;
   }

   public List<Observation> getValuesFromFed(KeysToFedNumbers fedSeriesName) {
      try {
         String xmlFromFed = pullMessage.pullMessageFromFed(fedSeriesName);
         Observations observations = toObservationsConverter.convertGdpFromXmlToObject(xmlFromFed);
         return observations.getObservation();
      } catch (IOException e) {
         throw new RuntimeException(e);
      }
   }
}
