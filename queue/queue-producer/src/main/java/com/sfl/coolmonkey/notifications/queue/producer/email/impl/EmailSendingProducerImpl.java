package com.sfl.coolmonkey.notifications.queue.producer.email.impl;

import com.sfl.coolmonkey.notifications.queue.model.email.SendEmailQueueModel;
import com.sfl.coolmonkey.notifications.queue.producer.email.EmailSendingProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 11:44
 */
@Component
public class EmailSendingProducerImpl implements EmailSendingProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSendingProducerImpl.class);

    //region Dependencies
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("#{appProperties['queue.sendemail']}")
    private String emailSendingQueueRoute;
    //endregion

    //region Constructors
    public EmailSendingProducerImpl() {
        LOGGER.debug("Initializing");
    }
    //endregion

    //region Public methods
    @Override
    public void produceEmailSendingEvent(@Nonnull final String emailUuid) {
        Assert.notNull(emailUuid, "The email uuid should not be null");
        LOGGER.debug("Producing email sending event with email uuid - {}", emailUuid);
        rabbitTemplate.convertAndSend(emailSendingQueueRoute, new SendEmailQueueModel(emailUuid));
    }
    //endregion
}
