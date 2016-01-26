package training.camel.errorHandler;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import training.camel.routers.Constants;
import training.camel.stuff.PreProcessingStatus;

/**
 * PreProcessErrorHandler.
 * 
 * @author winstanleyd
 */
@Component
//@Scope("prototype")
public class PreProcessErrorHandler implements Processor
{
  private final Logger mLogger = LoggerFactory.getLogger(getClass());
  
  /**
   * @see Processor
   * #process(org.apache.camel.Exchange)
   * {@inheritDoc}
   */
  public void process(Exchange aExchange) throws Exception
  {
    mLogger.error("AN EXCEPTION HAS OCCURRED IN PREPROCESSOR");
    String errorMessage;
    Exception exception = (Exception) aExchange.getProperty(Exchange.EXCEPTION_CAUGHT);
    if (exception != null)
    {
      errorMessage = exception.getMessage();
      mLogger.error("Exception: " + errorMessage, exception);
    }
    else
    {
      errorMessage = "Unknown exception";
      mLogger.error("Exception: " + errorMessage);
    }
    
    aExchange.getIn().setHeader(Constants.PRE_PROCESS_STATUS, PreProcessingStatus.EXCEPTION);
    aExchange.getIn().setHeader("errorMessage", errorMessage);
    return;
  }
}
