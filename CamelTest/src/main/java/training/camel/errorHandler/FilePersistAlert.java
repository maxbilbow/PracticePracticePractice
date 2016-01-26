package training.camel.errorHandler;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

/**
 * Persist Alert for the file processing
 * 
 * @author winstanleyd
 */
@Component
public class FilePersistAlert implements Processor
{
//  @Resource
//  private AlertDao mAlertDao;
//
//  @Resource
//  private AlertGroupDao mAlertGroupDao;
//
//  @Resource
//  private RequestFileDao mFileDao;
  
  /**
   * @see Processor
   * #process(org.apache.camel.Exchange)
   * {@inheritDoc}
   */
  public void process(Exchange anExchange) throws Exception
  {
//    FileCommand cmd = anExchange.getIn().getBody(FileCommand.class);
//
//    Alert alert = cmd.getAlert();
//    mAlertDao.makePersistent(alert);
//
//    RequestFile file = cmd.getIndustryFile();
//    if (file != null)
//    {
//      if (file.getAlertGroup() == null)
//      {
//        AlertGroup alertGroup = new AlertGroup();
//        alertGroup.setSource(AlertSource.MRV);
//        alertGroup.getAlerts().add(alert);
//        mAlertGroupDao.makePersistent(alertGroup);
//        file.setAlertGroup(alertGroup);
//      }
//      else
//      {
//        file.getAlertGroup().getAlerts().add(alert);
//        mAlertGroupDao.makePersistent(file.getAlertGroup());
//      }
//    }
//    file.setStatus(FileStatus.IN_ERROR);
//    mFileDao.makePersistent(file);
  }
}
