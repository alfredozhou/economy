package economics.action;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.TestCase;

/**
 * Created by IntelliJ IDEA.
 * User: zxzhou
 * Date: Feb 21, 2010
 * Time: 11:51:07 PM
 * To change this template use File | Settings | File Templates.
 */
public class TestyTest extends TestCase {
   public void testThatTheClassIsTheSame() {
        String blah = "blah";
        String bleh = "Poop";
       Class<? extends String> aClass = blah.getClass();
       Class<? extends String> aClass1 = bleh.getClass();
       assertTrue("class must be equal", aClass == aClass1);
    }


}
