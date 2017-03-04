package com.sfl.coolmonkey.notifications.service.email.impl;

import com.sfl.coolmonkey.notifications.persistence.repositories.email.EmailRepository;
import com.sfl.coolmonkey.notifications.service.common.component.CommonAssertionComponent;
import com.sfl.coolmonkey.notifications.service.email.EmailService;
import com.sfl.coolmonkey.notifications.service.email.dto.CreateEmailDto;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import com.sfl.coolmonkey.notifications.service.email.model.aggregation.AbstractEmailSendingState;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;
import java.util.Date;
import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/17/15
 * Time: 7:36 PM
 */
@Service
public class EmailServiceImpl implements EmailService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailServiceImpl.class);

    //region Dependencies
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private CommonAssertionComponent commonAssertionComponent;
    //endregion

    //region Constructors
    public EmailServiceImpl() {
        LOGGER.debug("Initializing email service");
    }
    //endregion

    //region Public methods
    @Override
    public Email getById(@Nonnull final ObjectId id) {
        commonAssertionComponent.assertObjectIdNotNull(id);
        final Email email = emailRepository.findOne(id);
        commonAssertionComponent.assertDomainModelNotNullForId(id, email);
        return email;
    }

    @Override
    public Email getByUuid(@Nonnull final String uuid) {
        commonAssertionComponent.assertUuidNotBlank(uuid);
        final Email email = emailRepository.findByUuid(uuid);
        commonAssertionComponent.assertDomainModelNotNullForUuid(uuid, email);
        return email;
    }

    @Override
    public Email create(@Nonnull final CreateEmailDto dto) {
        assertCreateEmailDto(dto);
        return emailRepository.save(buildEmailCreationEntityFromDto(dto));
    }

    @Override
    public Email addEmailSendingState(@Nonnull final String uuid, @Nonnull final AbstractEmailSendingState state) {
        commonAssertionComponent.assertUuidNotBlank(uuid);
        assertEmailSendingState(state);
        final Email email = getByUuid(uuid);
        email.getEmailSendingStates().add(state);
        email.setUpdated(new Date());
        return emailRepository.save(email);
    }

    @Override
    public List<Email> getByUuids(@Nonnull final List<String> uuids) {
        Assert.notNull(uuids);
        Assert.noNullElements(uuids.toArray());
        return emailRepository.findByUuidInAndRemovedIsNull(uuids);
    }
    //endregion

    //region Utility methods
    private Email buildEmailCreationEntityFromDto(final CreateEmailDto dto) {
        final Email email = new Email();
        email.setTo(dto.getTo());
        email.setFrom(dto.getFrom());
        email.setSenderName(dto.getSenderName());
        email.setSubject(dto.getSubject());
        email.setContent(dto.getContent());
        email.setAttachments(dto.getAttachments());
        email.setCc(dto.getCc());
        email.setBcc(dto.getBcc());
        email.setReplyEmail(dto.getReplyEmail());
        email.setOrigin(dto.getOrigin());
        return email;
    }
    //endregion

    //region Assertion methods
    private void assertCreateEmailDto(@Nonnull final CreateEmailDto dto) {
        Assert.notNull(dto);
        Assert.hasText(dto.getTo());
        Assert.hasText(dto.getFrom());
        Assert.hasText(dto.getContent());
    }

    private void assertEmailSendingState(final AbstractEmailSendingState state) {
        Assert.notNull(state);
    }
    //endregion
}
