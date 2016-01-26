package training.camel.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
@Configuration
@ComponentScan("training.camel")
@ImportResource({"classpath:training/config/camel-config.xml"})
public class MainConfig
{

}
