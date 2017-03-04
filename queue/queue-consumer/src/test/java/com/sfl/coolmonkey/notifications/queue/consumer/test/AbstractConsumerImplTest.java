package com.sfl.coolmonkey.notifications.queue.consumer.test;

import com.sfl.coolmonkey.notifications.queue.consumer.helper.ConsumerTestHelper;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 15:07
 */
@Ignore
@RunWith(EasyMockRunner.class)
public abstract class AbstractConsumerImplTest extends EasyMockSupport {

    //region Properties
    private final ConsumerTestHelper helper;
    //endregion

    //region Constructors
    public AbstractConsumerImplTest() {
        helper = new ConsumerTestHelper();
    }
    //endregion

    //region Properties getters and setters
    public ConsumerTestHelper getHelper() {
        return helper;
    }
    //endregion
}
