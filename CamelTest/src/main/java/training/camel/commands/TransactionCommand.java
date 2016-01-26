/**
 * 
 */
package training.camel.commands;

import org.joda.time.DateTime;
import training.camel.commands.framework.FrameworkCommand;

/**
 * Command area passed in the body of a Camel message to support processing of transactions
 * parsed from industry files.
 * 
 * @author grindleyk
 */
public class TransactionCommand extends FrameworkCommand
{
  // Common attributes
  private DateTime mReadDate;
  private String mReadValue;
  private String mFileType;

  // URS Attributes
  private Boolean mS72Rejection = Boolean.FALSE;
  private String mRejectionReason;

  public DateTime getReadDate()
  {
    return mReadDate;
  }

  public String getReadValue()
  {
    return mReadValue;
  }

  public String getFileType()
  {
    return mFileType;
  }


  public Boolean getS72Rejection()
  {
    return mS72Rejection;
  }

  public String getRejectionReason()
  {
    return mRejectionReason;
  }

  public void setReadDate(DateTime aReadDate)
  {
    mReadDate = aReadDate;
  }

  public void setReadValue(String aReadValue)
  {
    mReadValue = aReadValue;
  }

  public void setFileType(String aFileType)
  {
    mFileType = aFileType;
  }


  public void setS72Rejection(Boolean aS72Rejection)
  {
    mS72Rejection = aS72Rejection;
  }

  public void setRejectionReason(String aRejectionReason)
  {
    mRejectionReason = aRejectionReason;
  }
}