package training.casandra;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import training.casandra.client.SimpleClient;

/**
 * Created by bilbowm (Max Bilbow) on 15/01/2016.
 */

@SpringBootApplication
@PropertySource({
        "classpath:application.properties"
//        ,"file:///${appRootDir}/config/app.properties"
//        ,"file:///${appRootDir}/lib/version"
})
public class Application {

    static final Logger logger = Logger.getLogger(Application.class);
    public static void main(String [] args)
    {
        if (System.getProperty("timestamp") == null)
            System.setProperty("timestamp","na");
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        logger.info("Hello!");
        SimpleClient client = new SimpleClient();
        try {
            client.connect("127.0.0.1");
            logger.debug("Connected to cluster: " + client.getCluster().getClusterName());
            Thread.sleep(3000);
            client.close();
        } catch (InterruptedException e) {
           logger.error(e);
        } catch (Exception e) {
           logger.error(e);
        }

        SpringApplication.exit(context,()->0);
    }
}
