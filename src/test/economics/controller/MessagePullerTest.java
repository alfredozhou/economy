package economics.controller;

import economics.*;
import economics.dependencies.*;
import org.mockito.*;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MessagePullerTest extends MockitoTestCase {
   @Mock
   private UrlMaker urlMaker;
   @Mock
   private FedStringReader stringReader;


   public void testGetResponseFromFed() throws Exception {
      MessagePuller puller = new MessagePuller(urlMaker, stringReader);

      when(urlMaker.constructUrl(Mockito.any(KeysToFedNumbers.class))).thenReturn("URl");

      puller.pullMessageFromFed(KeysToFedNumbers.GDP);
      verify(stringReader).readStringFromFed("URl");

   }
}
