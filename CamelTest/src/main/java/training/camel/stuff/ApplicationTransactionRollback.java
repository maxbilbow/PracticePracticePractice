package training.camel.stuff;

import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Component;

/**
 * Application specific TransactionRollback.
 *
 * @author winstanleyd.
 */
@Component
public class ApplicationTransactionRollback //extends TransactionRollback
{
//  @Resource//(name="mrv_transactionManager")
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