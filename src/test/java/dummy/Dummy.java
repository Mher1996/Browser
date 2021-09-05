package dummy;

import base.BaseTest;
import dataprovider.IndexDataProvider;
import org.testng.annotations.*;

public class Dummy extends BaseTest {
    @Test()
    public void dummy() {
        System.out.println("PRIORITY  0");
    }
    @Test(priority = 10)
    public void dummy1() {
        System.out.println("PRIORITY  10");
    }
    @Test(priority = 1,enabled = false)
    public void dummy2() {
        System.out.println("PRIORITY  1");
    }
    @Test(priority = 111)
    public void dummy3() {
        System.out.println("PRIORITY  111");
    }
    @Test(priority = -10)
    public void dummy4() {
        System.out.println("PRIORITY -10 ");
    }


}
