package com.sfl.coolmonkey.notifications.queue.consumer.email.impl;

import com.sfl.coolmonkey.notifications.queue.consumer.email.EmailSendingConsumer;
import com.sfl.coolmonkey.notifications.queue.consumer.email.component.EmailSendingComponent;
import com.sfl.coolmonkey.notifications.queue.consumer.test.AbstractConsumerImplTest;
import com.sfl.coolmonkey.notifications.queue.model.email.SendEmailQueueModel;
import com.sfl.coolmonkey.notifications.service.email.EmailService;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;

import java.util.UUID;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.fail;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 15:38
 */
public class EmailSendingConsumerImplTest extends AbstractConsumerImplTest {

    //region Test subject and mocks
    @TestSubject
    private EmailSendingConsumer emailSendingConsumer = new EmailSendingConsumerImpl();

    @Mock
    private EmailService emailService;

    @Mock
    private EmailSendingComponent emailSendingComponent;
    //endregion

    //region Constructors
    public EmailSendingConsumerImplTest() {
    }
    //endregion

    //region Test methods

    //region consumeEmailSendingEvent
    @Test
    public void testConsumeEmailSendingEventWithInvalidArguments() {
        // Test data
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();
        // Run test scenario
        try {
            emailSendingConsumer.consumeEmailSendingEvent(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
        }
        try {
            emailSendingConsumer.consumeEmailSendingEvent(new SendEmailQueueModel(null));
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
        }
        // Verify
        verifyAll();
    }

    @Test
    public void testConsumeEmailSendingEvent() {
        // Test data
        final SendEmailQueueModel request = new SendEmailQueueModel(UUID.randomUUID().toString());
        final Email email = getHelper().createEmail();
        // Reset
        resetAll();
        // Expectations
        expect(emailService.getByUuid(request.getUuid())).andReturn(email);
        emailSendingComponent.processEmailSending(email);
        // Replay
        replayAll();
        // Run test scenario
        emailSendingConsumer.consumeEmailSendingEvent(request);
        // Verify
        verifyAll();
    }
    //endregion

    //endregion

}