package training.camel.stuff;

import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.springframework.stereotype.Component;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
@Component
public class SomeCheck implements Predicate
{
  /**
   * @see org.apache.camel.Predicate
   * #matches(org.apache.camel.Exchange)
   * {@inheritDoc}
   */
  public boolean matches(Exchange aExchange)
  {
//    PreProcessingStatus preProcessStatus = (PreProcessingStatus) aExchange.getIn().getHeaders().get(MrvConstants.PRE_PROCESS_STATUS);
//    if (preProcessStatus == null)
//    {
//      return true;
//    }
    return false;
  }
}
