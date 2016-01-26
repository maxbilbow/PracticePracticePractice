package org.apache.camel.example.spring.boot.processor;

import org.apache.camel.Processor;
import org.apache.log4j.Logger;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
public abstract class MyAbstractProcessor implements Processor
{
  protected Logger mLogger = Logger.getLogger(this.getClass());
}
