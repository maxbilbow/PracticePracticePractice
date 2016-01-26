package training.camel.errorHandler;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import training.camel.commands.DummyErrorCommand;
import training.camel.commands.framework.FrameworkCommand;
/**
 * FrameworkErrorHandler.
 * 
 * @author grindleyk, winstanleyd
 */
@Component
public class FrameworkErrorHandler implements Processor
{
  private Logger mLogger = LoggerFactory.getLogger(getClass());
  
  /**
   * @see Processor
   * #process(org.apache.camel.Exchange)
   * {@inheritDoc}
   */
  public void process(Exchange anExchange) throws Exception
  {    
    FrameworkCommand cmd = anExchange.getIn().getBody(FrameworkCommand.class);
    
    if (cmd == null)
    {
      cmd = new DummyErrorCommand();
    }
//
//    Alert alert = new Alert();
//    Exception exception = (Exception) anExchange.getProperty(Exchange.EXCEPTION_CAUGHT);
//    alert.setOperation(cmd.getLastOperationId());
//    alert.setOperationDescription(cmd.getLastDescription());
//    alert.setTimeRaised(cmd.getStartedTime());
//    alert.setType(AlertType.ERROR);
//    if (exception != null)
//    {
//      exception.printStackTrace();
//      mLogger.error("Exception during framework processing: " + exception.getMessage(), exception);
//      alert.setMessage("Exception message during framework processing: " + exception.getMessage());
//      cmd.getResults().add(new Result(Result.RESULT_FALSE, "Exception during framework processing: " + exception, cmd.getLastOperationId()));
//    }
//    else
//    {
//      alert.setMessage("Unknown Exception during framework processing");
//      cmd.getResults().add(new Result(Result.RESULT_FALSE, "Unknown Exception during framework processing", cmd.getLastOperationId()));
//    }
//    cmd.setAlert(alert);
  }
}
