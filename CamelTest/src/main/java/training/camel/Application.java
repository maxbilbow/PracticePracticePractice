package training.camel;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



/**
 * Created by bilbowm (Max Bilbow) on 15/01/2016.
 */
@SpringBootApplication
public class Application
{

    static final Logger logger = Logger.getLogger(Application.class);
    public static void main(String [] args)
    {
        if (System.getProperty("timestamp") == null)
            System.setProperty("timestamp","na");
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        logger.info("Hello!");
    }
}
