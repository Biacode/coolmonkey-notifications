package com.sfl.coolmonkey.notifications.queue.consumer.email.component.impl;

import com.sfl.coolmonkey.notifications.externalclients.coolfs.communicator.CoolFsServiceCommunicator;
import com.sfl.coolmonkey.notifications.queue.consumer.email.component.EmailSendingComponent;
import com.sfl.coolmonkey.notifications.queue.consumer.test.AbstractConsumerImplTest;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.test.util.ReflectionTestUtils;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 15:10
 */
public class EmailSendingComponentImplTest extends AbstractConsumerImplTest {

    //region Test subject and mocks
    @TestSubject
    private EmailSendingComponent emailSendingComponent = new EmailSendingComponentImpl();

    @Mock
    private CoolFsServiceCommunicator coolFsServiceCommunicator;
    //endregion

    //region Constructors
    public EmailSendingComponentImplTest() {
    }
    //endregion

    //region Test methods
    @Test
    public void testProcessEmailSendingWhenTheEnvironmentIsTest() {
        // Test data
        ReflectionTestUtils.setField(emailSendingComponent, "sendGridEnvironment", "test");
        final Email emailUuid = getHelper().createEmail();
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();
        // Run test scenario
        emailSendingComponent.processEmailSending(emailUuid);
        // Verify
        verifyAll();
    }
    //endregion

}