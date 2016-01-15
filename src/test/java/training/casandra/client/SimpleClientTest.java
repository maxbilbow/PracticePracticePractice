package training.casandra.client;

import org.junit.Test;

/**
 * Created by bilbowm (Max Bilbow) on 15/01/2016.
 */
public class SimpleClientTest {

    @Test
    public void testConnect() throws Exception
    {
        SimpleClient client = new SimpleClient();
        client.connect("127.0.0.1");
        client.close();
    }

    @Test
    public void testClose() throws Exception
    {

    }
}