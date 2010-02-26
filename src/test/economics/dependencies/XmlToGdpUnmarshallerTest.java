package economics.dependencies;

import economics.MockitoTestCase;
import economics.model.Observations;

public class XmlToGdpUnmarshallerTest extends MockitoTestCase {
    private final static String messageFromFed = "<?xml version=\"1.0\" encoding=\"utf-8\" ?>" +
            "<observations realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" observation_start=\"1776-07-04\" observation_end=\"9999-12-31\" units=\"lin\" output_type=\"1\" file_type=\"xml\" order_by=\"observation_date\" sort_order=\"asc\" count=\"80\" offset=\"0\" limit=\"100000\"> " +
            "<observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1931-01-01\" value=\"841.5\"/>  " +
            "<observation realtime_start=\"2010-01-18\" realtime_end=\"2010-01-18\" date=\"1932-01-01\" value=\"731.1\"/>  " +
            "</observations>";

    public void testConvertXmlToObject() {
        XmlToGdpUnmarshaller unmarshallerXmlTo = new XmlToGdpUnmarshaller();
        Observations observations = unmarshallerXmlTo.convertGdpFromXmlToObject(messageFromFed);
        assertNotNull(observations);
        assertCollectionSizeEquals(2, observations.getObservation());
    }
}
