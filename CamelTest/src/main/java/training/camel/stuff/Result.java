package training.camel.stuff;

/**
 * Created by bilbowm (Max Bilbow) on 26/01/2016.
 */
public class Result
{
  public final static Boolean RESULT_TRUE = Boolean.TRUE;
  public final static Boolean RESULT_FALSE = Boolean.FALSE;

  String mMessage;
  Boolean mValue;
  String mOperationId;

  public Result(Boolean aValue, String aMessage, String opId)
  {
    mValue = aValue;
    mMessage = aMessage;
    mOperationId = opId;
  }

  public Boolean getValue()
  {
    return mValue;
  }

  public void setValue(Boolean aValue)
  {
    mValue=aValue;
  }

  public String getMessage()
  {
    return mMessage;
  }

  public void setMessage(String aMessage)
  {
    mMessage=aMessage;
  }

  public String getOperationId()
  {
    return mOperationId;
  }

  public void setOperationId(String aOperationId)
  {
    mOperationId = aOperationId;
  }
}