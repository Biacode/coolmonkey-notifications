package com.sfl.coolmonkey.notifications.queue.consumer.email.impl;

import com.sfl.coolmonkey.notifications.queue.consumer.email.EmailSendingConsumer;
import com.sfl.coolmonkey.notifications.queue.consumer.email.component.EmailSendingComponent;
import com.sfl.coolmonkey.notifications.queue.model.email.SendEmailQueueModel;
import com.sfl.coolmonkey.notifications.service.email.EmailService;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 11:55
 */
@Component
public class EmailSendingConsumerImpl implements EmailSendingConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSendingConsumerImpl.class);

    //region Dependencies
    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailSendingComponent emailSendingComponent;
    //endregion

    //region Constructors
    public EmailSendingConsumerImpl() {
        LOGGER.debug("Initializing");
    }
    //endregion

    //region Public methods
    @Override
    @RabbitListener(queues = "#{appProperties['queue.sendemail']}")
    public void consumeEmailSendingEvent(@Nonnull final SendEmailQueueModel model) {
        assertSendEmailRequest(model);
        final Email email = emailService.getByUuid(model.getUuid());
        emailSendingComponent.processEmailSending(email);
    }
    //endregion

    //region Utility methods
    private void assertSendEmailRequest(final SendEmailQueueModel request) {
        Assert.notNull(request, "The send email model should not be null");
        Assert.notNull(request.getUuid(), "The email uuid should not be nul");
    }
    //endregion
}
