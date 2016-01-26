package training.camel.stuff;

import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


/**
 * Application specific TransactionCommit.
 * 
 * @author winstanleyd.
 */
@Component
public class ApplicationTransactionCommit //extends TransactionCommit
{
  @Resource(name="mrv_transactionManager")
  private HibernateTransactionManager mTransactionManager;

  /**

   * #getTransactionManager()
   * {@inheritDoc}
   */
  protected HibernateTransactionManager getTransactionManager()
  {
    return mTransactionManager;
  }
}
