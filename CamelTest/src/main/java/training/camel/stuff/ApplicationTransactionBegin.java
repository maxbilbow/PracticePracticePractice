package training.camel.stuff;

import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.stereotype.Component;

/**
 * Application specific TransactionBegin.
 *
 * @author winstanleyd.
 */
@Component
public class ApplicationTransactionBegin //extends TransactionBegin
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
