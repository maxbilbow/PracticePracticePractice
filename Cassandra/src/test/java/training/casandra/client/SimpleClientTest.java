package training.casandra.client;

import org.junit.Test;

/**
 * Created by bilbowm (Max Bilbow) on 15/01/2016.
 */
public class SimpleClientTest {

    @Test
    public void testConnect() throws Exception
    {
        SimpleClient client = simpleClient();
        client.createSchema();
        client.loadData();
        client.querySchema();
        client.dropSchema();
        client.close();
    }

    @Test
    public void testExtendedClient()
    {
        SimpleClient client = extendedClient();
        client.createSchema();
        client.loadData();
        client.querySchema();
//        client.getCluster().getConfiguration().getPolicies().
//        client.dropSchema();
        client.close();
    }

    @Test
    public void testDropSchema() throws Exception
    {
        simpleClient().dropSchema();
    }

    private SimpleClient simpleClient;

    private SimpleClient.ExtendedClient extendedClient;

    private SimpleClient simpleClient()
    {
        if (simpleClient != null)
            return simpleClient;
        SimpleClient client = new SimpleClient();
        client.connect("127.0.0.1");
        return this.simpleClient = client;
    }

    private SimpleClient.ExtendedClient extendedClient()
    {
        if (extendedClient != null)
            return extendedClient;
        SimpleClient.ExtendedClient client = new SimpleClient.ExtendedClient();
        client.connect("127.0.0.1");
        return this.extendedClient = client;
    }
}