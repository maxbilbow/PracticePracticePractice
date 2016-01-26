package training.camel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.LoggerFactory;
import training.camel.commands.framework.FrameworkCommand;
import training.camel.stuff.Result;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
public abstract class AbstractOperation<T extends FrameworkCommand> implements Processor
{
  private org.slf4j.Logger mLogger = LoggerFactory.getLogger(getClass());

  protected String mId;

  /**
   * @see org.apache.camel.Processor
   * #process(org.apache.camel.Exchange)
   * {@inheritDoc}
   */
  public abstract void process(Exchange aExchange) throws Exception;

  public void preProcess(Exchange aExchange) throws Exception
  {
    mLogger.debug(String.format("Running operation: %s, class : %s", aExchange.getUnitOfWork().getRouteContext().getRoute().getId(), getClass().getSimpleName()));
  }

  public abstract Result doProcess(Exchange exchange, T aCommand) throws Exception;

  public abstract String getDescription();

  public void postProcess(Exchange exchange) throws Exception
  { }

  public final String getId()
  {
    return mId;
  }

  public final void setId(String aId)
  {
    mId = aId;
  }

  protected Boolean isHeldOperation()
  {
    return Boolean.FALSE;
  }
}
