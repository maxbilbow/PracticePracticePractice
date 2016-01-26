package training.camel.processors;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;
import training.camel.stuff.Result;
import training.camel.stuff.SomeCommand;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
@Component
public class SugarProcessor extends AbstractOperation<SomeCommand> implements Processor
{
  @Override
  public void process(Exchange aExchange) throws Exception
  {
    SomeCommand command = aExchange.getIn().getBody(SomeCommand.class);
    if (command == null)
    {
      command = new SomeCommand();
    }

    if (isHeldOperation())
    {
      Result opResult = doProcess(aExchange, command);
      command.getResults().add(opResult);

      //set updated command as next message
      aExchange.getIn().setBody(command);
    }
    else
    {
      preProcess(aExchange);

      //run do process and get result
      Result opResult = doProcess(aExchange, command);

      command.setLastDescription(getDescription());
      command.setLastOperationId(getId());

      //add result to the list to track history
      command.getResults().add(opResult);

      //set updated command as next message
      aExchange.getIn().setBody(command);

      postProcess(aExchange);
    }
  }

  @Override
  public Result doProcess(Exchange exchange, SomeCommand aCommand) throws Exception
  {
    return null;
  }

  @Override
  public String getDescription()
  {
    return null;
  }


}
