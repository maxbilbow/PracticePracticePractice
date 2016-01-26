package org.apache.camel.example.spring.boot.processor;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
@Component
public class SayItAintSo extends MyAbstractProcessor
{
  @Override
  public void process(Exchange aExchange) throws Exception
  {
    mLogger.info("That ain't so!");
  }
}
