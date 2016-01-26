package org.apache.camel.example.spring.boot.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
@Component
public class SayItIsABird extends MyAbstractProcessor implements Processor
{

  @Override
  public void process(Exchange aExchange) throws Exception
  {
    mLogger.info("That thing is a bird!");
  }
}
