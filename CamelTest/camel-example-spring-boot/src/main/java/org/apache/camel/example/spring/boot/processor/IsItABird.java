package org.apache.camel.example.spring.boot.processor;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
@Component
public class IsItABird extends MyAbstractProcessor implements FrameworkProcessor
{

  boolean result = false;
  @Override
  public void process(Exchange aExchange) throws Exception
  {
//    System.out.println(
//            new ObjectInspector().inspectObject(aExchange));

    String message = aExchange.getFromEndpoint().getEndpointUri();
    if (message.contains("bird"))
      result = true;
  }

  @Override
  public boolean isPositive()
  {
    return result;
  }
}
