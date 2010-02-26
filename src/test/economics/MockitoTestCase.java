package economics;

import junit.framework.TestCase;
import org.mockito.MockitoAnnotations;
import economics.model.Observation;

import java.util.List;


public abstract class MockitoTestCase extends TestCase {
   @Override
   protected void setUp() throws Exception {
      super.setUp();
      MockitoAnnotations.initMocks(this);
   }

    public static void assertCollectionSizeGreaterThan(int expected, List<Observation> actual) {
        assertTrue("the actual list size should be greater than "+expected+" but was "+actual.size(), actual.size()> expected);
    }

     public static void assertCollectionSizeEquals(int expected, List<Observation> actual) {
        assertEquals("the actual list size should be greater than "+expected+" but was "+actual.size(), expected, actual.size());
    }
}
