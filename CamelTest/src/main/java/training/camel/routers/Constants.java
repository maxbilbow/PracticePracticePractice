package training.camel.routers;

/**
 * MrvConstants.
 *
 * @author grindleyk
 */
public class Constants
{

  public final static String RABBIT_CONSUMER_EXCEPTION = "RABBIT_CONSUMER_EXCEPTION";

  // Required by future File processing
  public static final String LINE_SEPARATOR = System.getProperty("line.separator");

  /** DATE FORMATS */
  public static final String WITHIN_FILE_DATE_FORMAT = "yyyyMMdd";
  public static final String FILE_HEADER_DATE_FORMAT = "yyyyMMdd";
  public static final String FILE_HEADER_TIME_FORMAT = "HHmmss";

  public static final String FILENAME_DATE_FORMAT = "ddMMyyyy";
  public static final String SCREEN_DATE_FORMAT = "dd/MM/yyyy";
  public static final String SCREEN_TIME_FORMAT = "HH:mm:ss";
  public static final String SCREEN_DATE_TIME_FORMAT = SCREEN_DATE_FORMAT + " " + SCREEN_TIME_FORMAT;

  public static final String PRE_PROCESS_STATUS = "PRE_PROCESS_STATUS";
}