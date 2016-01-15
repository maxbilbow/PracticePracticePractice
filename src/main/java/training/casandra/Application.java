package training.casandra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;

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

    public static void main(String [] args)
    {
        if (System.getProperty("timestamp") == null)
            System.setProperty("timestamp","na");
        ConfigurableApplicationContext context = SpringApplication.run(Application.class);
        System.out.println("Hello!");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SpringApplication.exit(context,()->0);
    }
}
