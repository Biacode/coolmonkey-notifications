package com.sfl.coolmonkey.notifications.queue.producer.email.impl;

import com.sfl.coolmonkey.notifications.queue.model.email.SendEmailQueueModel;
import com.sfl.coolmonkey.notifications.queue.producer.email.EmailSendingProducer;
import com.sfl.coolmonkey.notifications.queue.producer.test.AbstractProducerImplTest;
import com.sfl.coolmonkey.notifications.service.email.EmailService;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.UUID;

import static org.junit.Assert.fail;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 15:48
 */
public class EmailSendingProducerImplTest extends AbstractProducerImplTest {

    //region Test subject and mocks
    @TestSubject
    private EmailSendingProducer emailSendingProducer = new EmailSendingProducerImpl();

    @Mock
    private EmailService emailService;

    @Mock
    private RabbitTemplate rabbitTemplate;
    //endregion

    //region Constructors
    public EmailSendingProducerImplTest() {
    }
    //endregion

    //region Test methods

    //region produceEmailSendingEvent
    @Test
    public void testProduceEmailSendingEventWithInvalidArguments() {
        // Test data
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();
        // Run test scenario
        try {
            emailSendingProducer.produceEmailSendingEvent(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
        }
        // Verify
        verifyAll();
    }

    @Test
    public void testProduceEmailSendingEvent() {
        // Test data
        final String emailSendingQueueRoute = "sendEmailQueue";
        ReflectionTestUtils.setField(emailSendingProducer, "emailSendingQueueRoute", emailSendingQueueRoute);
        final String emailUuid = UUID.randomUUID().toString();
        final SendEmailQueueModel request = new SendEmailQueueModel(emailUuid);
        // Reset
        resetAll();
        // Expectations
        rabbitTemplate.convertAndSend(emailSendingQueueRoute, request);
        // Replay
        replayAll();
        // Run test scenario
        emailSendingProducer.produceEmailSendingEvent(emailUuid);
        // Verify
        verifyAll();
    }
    //endregion

    //endregion

}