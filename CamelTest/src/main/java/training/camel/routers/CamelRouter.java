package training.camel.routers;

import training.camel.processors.SugarProcessor;
import training.camel.stuff.ApplicationTransactionBegin;
import training.camel.stuff.ApplicationTransactionCommit;
import training.camel.stuff.ApplicationTransactionRollback;
import training.camel.stuff.SomeCheck;

import javax.annotation.Resource;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
public class CamelRouter extends AbstractPath
{

  @Resource
  private SugarProcessor mSugarProcessor;

  @Resource
  private SomeCheck mSomeCheck;

  @Override
  public void configure() throws Exception
  {
    initBeans();
    from("SomePlace").routeId("SomeRouteId")
            .errorHandler(getFrameworkPreProcessingError())
            .bean(ApplicationTransactionBegin.class)
             .choice()
            .when(mSomeCheck)
            .bean(ApplicationTransactionCommit.class)
            .otherwise()
            .bean(ApplicationTransactionRollback.class)
            .end();
  }

  private void initBeans()
  {
    mSugarProcessor.setId("SUGARJOB01");
  }


}
