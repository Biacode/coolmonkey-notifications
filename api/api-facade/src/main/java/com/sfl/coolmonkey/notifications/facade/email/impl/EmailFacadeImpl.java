package com.sfl.coolmonkey.notifications.facade.email.impl;

import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailWithAttachmentsModel;
import com.sfl.coolmonkey.notifications.api.model.email.request.EmailRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.GetEmailByUuidRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.GetEmailsByUuidsRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.UpdateEmailSendingStatesRequest;
import com.sfl.coolmonkey.notifications.api.model.email.response.EmailResponse;
import com.sfl.coolmonkey.notifications.api.model.email.response.GetEmailByUuidResponse;
import com.sfl.coolmonkey.notifications.api.model.email.response.GetEmailsByUuidsResponse;
import com.sfl.coolmonkey.notifications.api.model.email.response.UpdateEmailSendingStatesResponse;
import com.sfl.coolmonkey.notifications.facade.common.component.CommonMailRequestAssertionComponent;
import com.sfl.coolmonkey.notifications.facade.email.EmailFacade;
import com.sfl.coolmonkey.notifications.facade.email.component.EmailAttachmentComponent;
import com.sfl.coolmonkey.notifications.queue.producer.email.EmailSendingProducer;
import com.sfl.coolmonkey.notifications.service.email.EmailService;
import com.sfl.coolmonkey.notifications.service.email.dto.CreateEmailDto;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import com.sfl.coolmonkey.notifications.service.email.model.aggregation.AbstractEmailSendingState;
import ma.glasnost.orika.MapperFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/12/16
 * Time: 6:37 PM
 */
@Component
public class EmailFacadeImpl implements EmailFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailFacadeImpl.class);

    //region Dependencies
    @Autowired
    private EmailService emailService;

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private CommonMailRequestAssertionComponent commonMailRequestAssertionComponent;

    @Autowired
    private EmailAttachmentComponent emailAttachmentComponent;

    @Autowired
    private EmailSendingProducer emailSendingProducer;
    //endregion

    //region Constructors
    public EmailFacadeImpl() {
        LOGGER.debug("Initializing email facade");
    }
    //endregion

    //region Public methods
    @Nonnull
    @Override
    public ResultResponseModel<EmailResponse> send(@Nonnull final EmailRequest request) {
        commonMailRequestAssertionComponent.assertCommonMailRequest(request);
        final CreateEmailDto dto = mapperFacade.map(request.getEmail(), CreateEmailDto.class);
        LOGGER.debug("Saving email for dto - {}", dto);
        final Email email = emailService.create(dto);
        LOGGER.debug("Sending email - {} for provided email uuid - {}", email, email.getUuid());
        emailSendingProducer.produceEmailSendingEvent(email.getUuid());
        return new ResultResponseModel<>(new EmailResponse(mapperFacade.map(email, EmailModel.class)));
    }

    @Nonnull
    @Override
    public ResultResponseModel<UpdateEmailSendingStatesResponse> updateStates(@Nonnull final UpdateEmailSendingStatesRequest request) {
        assertUpdateEmailSendingStatesRequest(request);
        final List<EmailModel> emailModels = new ArrayList<>();
        request.getModels().stream()
                .filter(model -> emailService.getByUuid(model.getEmailUuid()).getTo().toLowerCase().equals(model.getEmail().toLowerCase()))
                .forEach(model -> {
                    final Email email = emailService.addEmailSendingState(model.getEmailUuid(), mapperFacade.map(model, AbstractEmailSendingState.class));
                    emailModels.add(mapperFacade.map(email, EmailModel.class));
                });
        return new ResultResponseModel<>(new UpdateEmailSendingStatesResponse(emailModels));
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetEmailsByUuidsResponse> getByUuids(@Nonnull final GetEmailsByUuidsRequest request) {
        assertGetByUuidsRequest(request);
        final List<Email> emails = emailService.getByUuids(request.getUuids());
        final List<EmailWithAttachmentsModel> models = mapperFacade.mapAsList(emails, EmailWithAttachmentsModel.class);
        final List<EmailWithAttachmentsModel> mappedModels = emailAttachmentComponent.mapAttachmentNames(models);
        return new ResultResponseModel<>(new GetEmailsByUuidsResponse(mappedModels));
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetEmailByUuidResponse> getByUuid(@Nonnull final GetEmailByUuidRequest request) {
        assertGetEmailByUuidRequest(request);
        final Email email = emailService.getByUuid(request.getUuid());
        return new ResultResponseModel<>(new GetEmailByUuidResponse(mapperFacade.map(email, EmailModel.class)));
    }
    //endregion

    //region Utility methods
    private void assertUpdateEmailSendingStatesRequest(final UpdateEmailSendingStatesRequest request) {
        Assert.notNull(request);
        Assert.notEmpty(request.getModels());
        Assert.noNullElements(request.getModels().toArray());
    }

    private void assertGetByUuidsRequest(final GetEmailsByUuidsRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getUuids());
        Assert.noNullElements(request.getUuids().toArray());
    }

    private void assertGetEmailByUuidRequest(final GetEmailByUuidRequest request) {
        Assert.notNull(request);
        Assert.notNull(request.getUuid());
    }
    //endregion
}
