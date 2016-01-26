package training.camel.stuff;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import training.camel.routers.Constants;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
@Component
public class SomeCheck implements Predicate
{
  protected org.slf4j.Logger mLogger = LoggerFactory.getLogger(getClass());

  /**
   * @see org.apache.camel.Predicate
   * #matches(org.apache.camel.Exchange)
   * {@inheritDoc}
   */
  public boolean matches(Exchange aExchange)
  {
    PreProcessingStatus preProcessStatus = (PreProcessingStatus) aExchange.getIn().getHeaders().get(Constants.PRE_PROCESS_STATUS);
    if (preProcessStatus == null)
    {
      mLogger.info("preProcessStatus == null");
      return true;
    }
    mLogger.info("preProcessStatus != null");
    return false;
  }
}
