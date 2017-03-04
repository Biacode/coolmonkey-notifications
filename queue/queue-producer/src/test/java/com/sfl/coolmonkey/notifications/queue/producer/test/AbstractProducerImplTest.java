package com.sfl.coolmonkey.notifications.queue.producer.test;

import com.sfl.coolmonkey.notifications.queue.producer.helper.ProducerTestHelper;
import org.easymock.EasyMockRunner;
import org.easymock.EasyMockSupport;
import org.junit.Ignore;
import org.junit.runner.RunWith;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 15:45
 */
@Ignore
@RunWith(EasyMockRunner.class)
public abstract class AbstractProducerImplTest extends EasyMockSupport {

    //region Properties
    private final ProducerTestHelper helper;
    //endregion

    //region Constructors
    public AbstractProducerImplTest() {
        helper = new ProducerTestHelper();
    }
    //endregion

    //region Properties getters and setters
    public ProducerTestHelper getHelper() {
        return helper;
    }
    //endregion

}
