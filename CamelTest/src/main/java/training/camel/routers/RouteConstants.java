package training.camel.routers;
/**
 *
 * All application Camel paths(channels) should be defined here.
 *
 * @author grindleyk
 *
 */
public class RouteConstants
{
  public static final String JOB_IN_PRE_PROCESSING_CHANNEL = "direct:inputJobQueuePreProcess";
  public static final String JOB_IN_PROCESSING_CHANNEL = "direct:inputJobQueueProcess";
  public static final String JOB_IN_FUNCTIONS_CHANNEL = "direct:inputJobQueueFunctions";
  public static final String JOB_IN_PRE_PROCESSING_ROUTE_ID = "JOB_IN_PRE_PROCESSING_ROUTE";
  public static final String JOB_IN_PROCESSING_ROUTE_ID = "JOB_IN_PROCESSING_ROUTE";
  public static final String JOB_IN_FUNCTIONS_ROUTE_ID = "JOB_IN_FUNCTIONS_ROUTE_ID_ROUTE";

  public static final String FILE_IN_PRE_PROCESSING_CHANNEL = "direct:inputFileQueuePreProcess";
  public static final String FILE_IN_PROCESSING_CHANNEL = "direct:inputFileQueueProcess";
  public static final String FILE_IN_PRE_PROCESSING_ROUTE_ID = "FILE_IN_PRE_PROCESSING_ROUTE";
  public static final String FILE_IN_PROCESSING_ROUTE_ID = "FILE_IN_PROCESSING_ROUTE";

  public static final String TX_IN_PRE_PROCESSING_CHANNEL = "direct:inputTxQueuePreProcess";
  public static final String TX_IN_PROCESSING_CHANNEL = "direct:inputTxQueueProcess";
  public static final String TX_IN_FUNCTIONS_CHANNEL = "direct:inputTxQueueFunctions";
  public static final String TX_IN_PRE_PROCESSING_ROUTE_ID = "TX_IN_PRE_PROCESSING_ROUTE";
  public static final String TX_IN_PROCESSING_ROUTE_ID = "TX_IN_PROCESSING_ROUTE";
  public static final String TX_IN_FUNCTIONS_ROUTE_ID = "TX_IN_FUNCTIONS_ROUTE_ID";

  public static final String TX_IN_URS_CHANNEL = "direct:transactionUrsChannel";
  public static final String TX_IN_SFR_CHANNEL = "direct:transactionSfrChannel:";
  public static final String TX_IN_URS_ROUTE_ID = "TX_IN_URS_ROUTE_ID";
  public static final String TX_IN_SFR_ROUTE_ID = "TX_IN_SFR_ROUTE_ID";

  public static final String URS_SFR_PROCESSING_CHANNEL = "direct:inputUrsSfrProcess";
  public static final String URS_SFR_PROCESSING_ROUTE_ID = "URS_SFR_PROCESSING_ROUTE_ID";

  public final static String JOB_VALIDATE_AND_FORWARD_CHANNEL = "direct:JOB_VALIDATE_AND_FORWARD";
  public final static String JOB_VALIDATE_AND_FORWARD_ROUTE_ID = "JOB_VALIDATE_AND_FORWARD";

  public final static String JOB_CALCULATION_AND_FORWARD_CHANNEL = "direct:JOB_CALCULATE_AND_FORWARD";
  public final static String JOB_CALCULATION_FORWARD_ROUTE_ID = "JOB_CALCULATE_AND_FORWARD";

  public final static String JOB_FORWARD_CHANNEL = "direct:JOB_FORWARD";
  public final static String JOB_FORWARD_ROUTE_ID = "JOB_FORWARD";
  public final static String JOB_CONVERTER_CHANNEL = "direct:JOB_CONVERTER";
  public final static String JOB_CONVERTER_ROUTE_ID = "JOB_CONVERTER";
  public final static String JOB_SETTLEMENTCLASS2PATH_CHANNEL = "direct:JOB_SETTLEMENT_CLASS_2";
  public final static String JOB_SETTLEMENTCLASS2PATH__ROUTE_ID = "JOB_SETTLEMENT_CLASS_2";
  public final static String JOB_SETTLEMENTCLASS3PATH_CHANNEL = "direct:JOB_SETTLEMENT_CLASS_3";
  public final static String JOB_SETTLEMENTCLASS3PATH__ROUTE_ID = "JOB_SETTLEMENT_CLASS_3";
  public final static String JOB_SETTLEMENTCLASS4PATH_CHANNEL = "direct:JOB_SETTLEMENT_CLASS_4";
  public final static String JOB_SETTLEMENTCLASS4PATH__ROUTE_ID = "JOB_SETTLEMENT_CLASS_4";
  public final static String JOB_REPLACE_READ_CHANNEL = "direct:JOB_REPLACE_READ";
  public final static String JOB_REPLACE_READ_ROUTE_ID = "JOB_REPLACE_READ";
  public final static String JOB_CHECK_VALIDATION_CHANNEL = "direct:JOB_CHECK_VALIDATION";
  public final static String JOB_CHECK_VALIDATION_ROUTE_ID= "JOB_CHECK_VALIDATION";

  public final static String MRV_FAILED_PATH = "direct:MRV_FAILED_PATH";
  public final static String MRV_HELD_PATH = "direct:MRV_HELD_PATH";
  public final static String MRV_SUCC_PATH = "direct:MRV_SUCC_PATH";
  public final static String MRV_POST_FAILED_PATH = "direct:MRV_POST_FAILED_PATH";
  public final static String MRV_POST_HELD_PATH = "direct:MRV_POST_HELD_PATH";
  public final static String MRV_POST_SUCC_PATH = "direct:MRV_POST_SUCC_PATH";

  public static final String FRAMEWORK_PRE_PROCESSING_ERROR_CHANNEL = "direct:frameworkPreProcessingErrorChannel";
  public static final String FRAMEWORK_PROCESSING_ERROR_CHANNEL = "direct:frameworkProcessingErrorChannel";
  public static final String FRAMEWORK_POST_PROCESSING_ERROR_CHANNEL = "direct:frameworkPostProcessingErrorChannel";
  public static final String FRAMEWORK_PROCESSING_CATCH_ALL_ERROR_CHANNEL = "direct:frameworkProcessingCatchAllErrorChannel";

  public static final String FILE_PRE_PROCESSING_ERROR_CHANNEL = "direct:filePreProcessingErrorChannel";
  public static final String FILE_PROCESSING_ERROR_CHANNEL = "direct:fileProcessingErrorChannel";

  public static final String FRAMEWORK_PRE_PROCESSING_ERROR_ROUTE_ID = "FRAMEWORK_PRE_PROCESSING_ERROR_ROUTE";
  public static final String FRAMEWORK_PROCESSING_ERROR_ROUTE_ID = "FRAMEWORK_PROCESSING_ERROR_ROUTE";
  public static final String FRAMEWORK_POST_PROCESSING_ERROR_ROUTE_ID = "FRAMEWORK_POST_PROCESSING_ERROR_ROUTE";
  public static final String FRAMEWORK_PROCESSING_CATCH_ALL_ERROR_ROUTE_ID = "FRAMEWORK_PROCESSING_CATCH_ALL_ERROR_ROUTE_ID";

  public static final String FILE_PRE_PROCESSING_ERROR_ROUTE_ID = "FILE_PRE_PROCESSING_ERROR_ROUTE";
  public static final String FILE_PROCESSING_ERROR_ROUTE_ID = "FILE_PROCESSING_ERROR_ROUTE";

  //public static final String RABBIT_CONSUMER_ALERT_CHANNEL = "direct:rabbitConsumerAlertChannel";
  //public static final String RABBIT_CONSUMER_ALERT_ROUTE_ID = "RABBIT_CONSUMER_ALERT_ROUTE";
}
