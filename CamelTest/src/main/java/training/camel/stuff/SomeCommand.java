package training.camel.stuff;

import training.camel.commands.framework.FrameworkCommand;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
public class SomeCommand extends FrameworkCommand
{
  private List<Result> mResults = new ArrayList<>();

  public List<Result> getResults()
  {
    return mResults;
  }
}
