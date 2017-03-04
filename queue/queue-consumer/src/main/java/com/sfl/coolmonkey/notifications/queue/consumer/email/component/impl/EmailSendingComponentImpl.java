package com.sfl.coolmonkey.notifications.queue.consumer.email.component.impl;

import com.sendgrid.SendGrid;
import com.sendgrid.SendGridException;
import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.coolfs.api.model.storage.FileLoadModel;
import com.sfl.coolmonkey.coolfs.api.model.storage.request.LoadFileByUuidRequest;
import com.sfl.coolmonkey.coolfs.api.model.storage.response.LoadFileByUuidResponse;
import com.sfl.coolmonkey.notifications.externalclients.coolfs.communicator.CoolFsServiceCommunicator;
import com.sfl.coolmonkey.notifications.queue.consumer.common.exception.ConsumerQueueRuntimeException;
import com.sfl.coolmonkey.notifications.queue.consumer.email.component.EmailSendingComponent;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Nonnull;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 14:58
 */
@Component
public class EmailSendingComponentImpl implements EmailSendingComponent {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailSendingComponentImpl.class);

    //region Constants
    private static final String TEST_ENVIRONMENT = "test";
    //endregion

    //region Dependencies
    @Value("#{appProperties['sendgrid.apikey']}")
    private String sendGridApiKey;

    @Value("#{appProperties['sendgrid.environment']}")
    private String sendGridEnvironment;

    @Autowired
    private CoolFsServiceCommunicator coolFsServiceCommunicator;
    //endregion

    //region Constructors
    public EmailSendingComponentImpl() {
        LOGGER.debug("Initializing");
    }
    //endregion

    //region Public methods
    @Override
    public void processEmailSending(@Nonnull final Email email) {
        if (!Objects.equals(sendGridEnvironment, TEST_ENVIRONMENT)) {
            final SendGrid sendgrid = new SendGrid(sendGridApiKey);
            LOGGER.debug("Successfully initialized send grid instance - {}", sendgrid);
            final SendGrid.Email emailForm = buildEmailFormFromEmail(email);
            emailForm.addUniqueArg("emailUuid", email.getUuid());
            emailForm.addUniqueArg("origin", email.getOrigin().toString());
            addAttachmentsToEmailForm(email.getAttachments(), emailForm);
            try {
                LOGGER.debug("Trying to send email with form - {}", emailForm);
                final SendGrid.Response response = sendgrid.send(emailForm);
                LOGGER.debug("Successfully sent an email with response - {}", response);
            } catch (final SendGridException e) {
                LOGGER.error("An error occurred while trying to send email - {}", email);
                throw new ConsumerQueueRuntimeException("An error occurred while trying to send email - " + email, e);
            }
        }
    }
    //endregion

    //region Utility methods
    private SendGrid.Email buildEmailFormFromEmail(final Email email) {
        final SendGrid.Email emailForm = new SendGrid.Email();
        emailForm.addTo(email.getTo());
        emailForm.setFrom(email.getFrom());
        emailForm.setFromName(email.getSenderName());
        emailForm.setSubject(email.getSubject());
        if (email.getCc() != null) {
            emailForm.setCc(email.getCc().toArray(new String[email.getCc().size()]));
        }
        if (email.getBcc() != null) {
            emailForm.setBcc(email.getBcc().toArray(new String[email.getBcc().size()]));
        }
        emailForm.setHtml(email.getContent());
        emailForm.setReplyTo(email.getReplyEmail());
        return emailForm;
    }

    private void addAttachmentsToEmailForm(final List<String> attachments, final SendGrid.Email emailForm) {
        attachments.forEach(attachmentUuid -> {
            final ResultResponseModel<LoadFileByUuidResponse> storageMsResponse = coolFsServiceCommunicator.downloadFileByUuid(new LoadFileByUuidRequest(attachmentUuid));
            final FileLoadModel loadFileModel = storageMsResponse.getResponse().getLoadFileModel();
            try {
                emailForm.addAttachment(loadFileModel.getFileName(), loadFileModel.getInputStream());
            } catch (final IOException ignore) {
                // Ignore
            }
        });
    }
    //endregion
}
