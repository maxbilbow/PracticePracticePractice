/**
 * 
 */
package training.camel.commands;




import java.util.ArrayList;
import java.util.List;

/**
 * Command area passed in the body of a Camel message to support processing of industry files.
 * 
 * @author grindleyk
 */
public class FileCommand
{
  private List<Object> mV8Errors = new ArrayList<>();
  

  private Object mGasFlow;
  
  private List<Object> mRequestTransactionPairs = new ArrayList<>();
  private List<Object> mTransactionMessages;


  
  public List<Object> getRequestTransactionPairs()
  {
    return mRequestTransactionPairs;
  }
  

  
  public Object getGasFlow()
  {
    return mGasFlow;
  }
  
  public void setGasFlow(Object aGasFlow)
  {
    mGasFlow = aGasFlow;
  }
  

  public List<Object> getTransactionMessages()
  {
    return mTransactionMessages;
  }
  
  public void setTransactionMessages(List<Object> aTransactionMessages)
  {
    mTransactionMessages = aTransactionMessages;
  }
  
  public void addV8Error(Object aError)
  {
    mV8Errors.add(aError);
  }
  
  public Boolean hasV8Errors()
  {
    if (mV8Errors == null || mV8Errors.isEmpty())
    {
      return Boolean.FALSE;
    }
    return Boolean.TRUE;
  }
  
  public List<Object> getV8Errors()
  {
    return mV8Errors;
  }
  
  public List<String> getV8ErrorStrings()
  {
    List<String> v8ErrorStrings = new ArrayList<String>();
    for (Object currentError : mV8Errors)
    {
      v8ErrorStrings.add(currentError + " : " + currentError);
    }
    return v8ErrorStrings;
  }
  
  public String getV8ErrorsString()
  {
    StringBuilder v8ErrorsAsString = new StringBuilder();
    boolean isFirst = true;
    for (Object currentError : mV8Errors)
    {
      if (isFirst)
      {
        v8ErrorsAsString.append("[" + currentError + " : " + currentError + "]");
        isFirst = false;
      }
      else
      {
        v8ErrorsAsString.append(", [" + currentError + " : " + currentError + "]");
      }
    }
    return v8ErrorsAsString.toString();
  }
  
  public void setV8Errors(List<Object> aV8Errors)
  {
    mV8Errors = aV8Errors;
  }
  
  public List<String> getFormattedV8Errors()
  {
    int errorIndex = 1;
    int errorCount = mV8Errors.size();
    List<String> formattedV8Errors = new ArrayList<String>();
    for (Object currentError : mV8Errors)
    {
      formattedV8Errors.add(getFormattedErrorMessage(errorIndex, errorCount, currentError.toString(), currentError.toString(),
                                                     1));
      errorIndex++;
    }
    return formattedV8Errors;
  }
  
  private String getFormattedErrorMessage(int aErrorIndex,
                                          int aErrorCount,
                                          String aErrorMessage,
                                          String aErrorType,
                                          int aLineNumber)
  {
    String errorMessage;
    if (aErrorType == null)
    {
      if (aLineNumber == -1)
      {
        errorMessage = "(Reason " + aErrorIndex + " of " + aErrorCount + ") - " + aErrorMessage;
      }
      else
      {
        errorMessage = "(Reason " + aErrorIndex + " of " + aErrorCount + ") - " + aErrorMessage + " at line " + aLineNumber;
      }
    }
    else
    {
      if (aLineNumber == -1)
      {
        errorMessage = "(Reason " + aErrorIndex + " of " + aErrorCount + ") - " + aErrorType + " : " + aErrorMessage;
      }
      else
      {
        errorMessage = "(Reason " + aErrorIndex + " of " + aErrorCount + ") - " + aErrorType + " : " + aErrorMessage + " at line " + aLineNumber;
      }
    }
    return errorMessage.replace('[', '(').replace(']', ')');
  }
}
