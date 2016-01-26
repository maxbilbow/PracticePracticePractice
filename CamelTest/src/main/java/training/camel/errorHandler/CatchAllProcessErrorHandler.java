package training.camel.errorHandler;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * CatchAllProcessErrorHandler.
 * 
 * @author winstanleyd
 */
@Component
@Scope("prototype")
public class CatchAllProcessErrorHandler implements Processor
{
  private final Logger mLogger = LoggerFactory.getLogger(getClass());
  
  /**
   * @see Processor
   * #process(org.apache.camel.Exchange)
   * {@inheritDoc}
   */
  public void process(Exchange aExchange) throws Exception
  {
    mLogger.error("AN EXCEPTION HAS OCCURRED IN PROCESSOR");
    Exception exception = (Exception) aExchange.getProperty(Exchange.EXCEPTION_CAUGHT);
    if (exception != null)
    {
      exception.printStackTrace();
      mLogger.error("Exception: " + exception.getMessage(), exception);
    }
  }
}
