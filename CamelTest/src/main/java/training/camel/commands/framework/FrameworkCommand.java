/**
 * 
 */
package training.camel.commands.framework;

import org.joda.time.DateTime;
import training.camel.stuff.Result;
import java.util.ArrayList;
import java.util.List;

/**
 * Framework only attributes that need to be passed over routes
 * 
 * @author grindleyk, winstanleyd, morrisg
 */
public abstract class FrameworkCommand
{
  private String mLastOperationId;
  private String mLastDescription;
  private String mFailedReason;
  private List<Result> mResults = new ArrayList<>();

  private DateTime mStartedTime;
  private String mMessageType;
  private String mVersion;
  
  private String mMtpnt;
  private String mSerialNumber;
  
  /**
   * @return the mtpnt
   */
  public String getMtpnt()
  {
    return mMtpnt;
  }
  
  /**
   * @return the serialNumber
   */
  public String getSerialNumber()
  {
    return mSerialNumber;
  }
  
  /**
   * @param aMtpnt the mtpnt to set
   */
  public void setMtpnt(String aMtpnt)
  {
    mMtpnt = aMtpnt;
  }
  
  /**
   * @param aSerialNumber the serialNumber to set
   */
  public void setSerialNumber(String aSerialNumber)
  {
    mSerialNumber = aSerialNumber;
  }
  
  /**
   * @return the messageType
   */
  public String getMessageType()
  {
    return mMessageType;
  }

  /**
   * @return the version
   */
  public String getVersion()
  {
    return mVersion;
  }

  /**
   * @param aMessageType the messageType to set
   */
  public void setMessageType(String aMessageType)
  {
    mMessageType = aMessageType;
  }

  /**
   * @param aVersion the version to set
   */
  public void setVersion(String aVersion)
  {
    mVersion = aVersion;
  }

  public DateTime getStartedTime()
  {
    return mStartedTime;
  }
  
  public void setStartedTime(DateTime aStartedTime)
  {
    mStartedTime = aStartedTime;
  }
  
  public Result getLastResult()
  {
    return getResults().get(getResults().size() - 1);
  }
  
  public String getLastOperationId()
  {
    return mLastOperationId;
  }
  
  public String getLastDescription()
  {
    return mLastDescription;
  }
  
  public List<Result> getResults()
  {
    return mResults;
  }
  

  
  public void setLastOperationId(String aLastOperationId)
  {
    mLastOperationId = aLastOperationId;
  }
  
  public void setLastDescription(String aLastDescription)
  {
    mLastDescription = aLastDescription;
  }
  
  public void setResults(List<Result> aResults)
  {
    mResults = aResults;
  }
  

  
  public void addResult(Result aResult)
  {
    mResults.add(aResult);
  }

  /**
   * @return the failedReason
   */
  public String getFailedReason()
  {
    return mFailedReason;
  }

  /**
   * @param aFailedReason the failedReason to set
   */
  public void setFailedReason(String aFailedReason)
  {
    mFailedReason = aFailedReason;
  }
}
