import level0.proxy.BizService;
import level0.proxy.dyncproxy.DynProxyHandler;
import level0.proxy.dyncproxy.UserBizService;
import org.junit.Test;

import java.io.BufferedReader;

public class MainTest {
    @Test
    public void testDynProxy() {
        System.out.println(7 & 3);
        System.out.println(6 & 9);
    }
}
