package training.camel.routers;

import org.apache.camel.ErrorHandlerFactory;
import org.apache.camel.Predicate;
import org.apache.camel.builder.DeadLetterChannelBuilder;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.processor.RedeliveryPolicy;
import training.camel.commands.framework.FrameworkCommand;
import training.camel.errorHandler.CatchAllProcessErrorHandler;
import training.camel.errorHandler.FrameworkErrorHandler;
import training.camel.errorHandler.PreProcessErrorHandler;
import training.camel.stuff.ApplicationTransactionBegin;
import training.camel.stuff.ApplicationTransactionRollback;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
public abstract class AbstractPath extends RouteBuilder
{
  protected static ErrorHandlerFactory mFrameworkPreProcessingErrorHandler;
  protected static ErrorHandlerFactory mFrameworkProcessingErrorHandler;
  protected static ErrorHandlerFactory mFrameworkPostProcessingErrorHandler;
  protected static ErrorHandlerFactory mFrameworkCatchAllProcessingErrorHandler;

  public final Predicate resultIsPositive= (exchange) ->
  {
    return exchange.getIn().getBody(FrameworkCommand.class).getLastResult().getValue();
  };

  public final Predicate resultIsNegative= (exchange) ->
  {
    return !exchange.getIn().getBody(FrameworkCommand.class).getLastResult().getValue();
  };

  protected final ErrorHandlerFactory getFrameworkPreProcessingError()
  {
    if (mFrameworkPreProcessingErrorHandler != null)
    {
      return mFrameworkPreProcessingErrorHandler;
    }
    else
    {
      DeadLetterChannelBuilder errorHandler = deadLetterChannel(RouteConstants.FRAMEWORK_PRE_PROCESSING_ERROR_CHANNEL);
      errorHandler.setRedeliveryPolicy(new RedeliveryPolicy().disableRedelivery()); //disable redelivery

      from(RouteConstants.FRAMEWORK_PRE_PROCESSING_ERROR_CHANNEL)
              .routeId(RouteConstants.FRAMEWORK_PRE_PROCESSING_ERROR_ROUTE_ID)
              .bean(PreProcessErrorHandler.class)
              .bean(ApplicationTransactionRollback.class)
              .end();

      mFrameworkPreProcessingErrorHandler = errorHandler;
    }
    return mFrameworkPreProcessingErrorHandler;
  }

  protected final ErrorHandlerFactory getFrameworkProcessingError()
  {
    if (mFrameworkProcessingErrorHandler != null)
    {
      return mFrameworkProcessingErrorHandler;
    }
    else
    {
      DeadLetterChannelBuilder errorHandler = deadLetterChannel(RouteConstants.FRAMEWORK_PROCESSING_ERROR_CHANNEL);
      errorHandler.setRedeliveryPolicy(new RedeliveryPolicy().disableRedelivery()); //disable redelivery

      from(RouteConstants.FRAMEWORK_PROCESSING_ERROR_CHANNEL)
              .routeId(RouteConstants.FRAMEWORK_PROCESSING_ERROR_ROUTE_ID)
              .errorHandler(getCatchAllProcessErrorHandler())
              .bean(ApplicationTransactionRollback.class)
              .bean(ApplicationTransactionBegin.class)
              .bean(FrameworkErrorHandler.class)
//              .bean(RecordErrorRequest.class)
//              .bean(ApplicationTransactionCommit.class)
              .end();

      mFrameworkProcessingErrorHandler = errorHandler;
    }
    return mFrameworkProcessingErrorHandler;
  }

  protected final ErrorHandlerFactory getFrameworkPostProcessingError()
  {
    if (mFrameworkPostProcessingErrorHandler != null)
    {
      return mFrameworkPostProcessingErrorHandler;
    }
    else
    {
      DeadLetterChannelBuilder errorHandler = deadLetterChannel(RouteConstants.FRAMEWORK_POST_PROCESSING_ERROR_CHANNEL);
      errorHandler.setRedeliveryPolicy(new RedeliveryPolicy().disableRedelivery()); //disable redelivery

      from(RouteConstants.FRAMEWORK_POST_PROCESSING_ERROR_CHANNEL)
              .routeId(RouteConstants.FRAMEWORK_POST_PROCESSING_ERROR_ROUTE_ID)
              .bean(CatchAllProcessErrorHandler.class)
              .end();

      mFrameworkPostProcessingErrorHandler = errorHandler;
    }
    return mFrameworkPostProcessingErrorHandler;
  }

  private final ErrorHandlerFactory getCatchAllProcessErrorHandler()
  {
    if (mFrameworkCatchAllProcessingErrorHandler != null)
    {
      return mFrameworkCatchAllProcessingErrorHandler;
    }
    else
    {
      DeadLetterChannelBuilder errorHandler = deadLetterChannel(RouteConstants.FRAMEWORK_PROCESSING_CATCH_ALL_ERROR_CHANNEL);
      errorHandler.setRedeliveryPolicy(new RedeliveryPolicy().disableRedelivery()); //disable redelivery

      from(RouteConstants.FRAMEWORK_PROCESSING_CATCH_ALL_ERROR_CHANNEL)
              .routeId(RouteConstants.FRAMEWORK_PROCESSING_CATCH_ALL_ERROR_ROUTE_ID)
              .bean(CatchAllProcessErrorHandler.class)
              .bean(ApplicationTransactionRollback.class)
              .end();

      mFrameworkCatchAllProcessingErrorHandler = errorHandler;
    }
    return mFrameworkCatchAllProcessingErrorHandler;
  }
}
