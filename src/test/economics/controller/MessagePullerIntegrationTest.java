package economics.controller;

import economics.MockitoTestCase;
import economics.dependencies.EconomicProperties;

public class MessagePullerIntegrationTest extends MockitoTestCase {
    public void testGetResponseFromFed() throws Exception {
        MessagePuller puller = new MessagePuller(new EconomicProperties());
        String msgFromFed = puller.pullMessageFromFed();
        assertNotNull(msgFromFed);
    }
}
