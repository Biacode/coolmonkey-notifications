package com.sfl.coolmonkey.notifications.facade.helper;

import com.sfl.coolmonkey.commons.api.model.response.AbstractResponseModel;
import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.coolfs.api.model.storage.StoredFileInfoModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailWithAttachmentsModel;
import com.sfl.coolmonkey.notifications.api.model.email.aggregation.AbstractEmailSendingStateModel;
import com.sfl.coolmonkey.notifications.api.model.email.aggregation.BounceEmailSendingStateModel;
import com.sfl.coolmonkey.notifications.api.model.email.aggregation.ClickEmailSendingStateModel;
import com.sfl.coolmonkey.notifications.api.model.email.request.UpdateEmailSendingStatesRequest;
import com.sfl.coolmonkey.notifications.service.helper.CommonTestHelper;

import java.util.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 7/20/15
 * Time: 2:51 PM
 */
public class FacadeImplTestHelper extends CommonTestHelper {

    //region Constants
    //endregion

    //region Constructors
    public FacadeImplTestHelper() {
    }
    //endregion

    //region Public methods

    //region Common
    @SafeVarargs
    public final <T extends AbstractResponseModel> void assertResultResponseModel(final ResultResponseModel<T>... results) {
        for (final ResultResponseModel<T> result : results) {
            assertNotNull(result);
            assertFalse(result.hasErrors());
        }
    }
    //endregion

    //region Email
    public EmailModel createEmailModel() {
        final EmailModel emailModel = new EmailModel();
        emailModel.setTo("arthur.asatryan@sflpro.com");
        emailModel.setFrom("biacoder@gmail.com");
        emailModel.setSubject("Test subject");
        emailModel.setContent("Test content");
        emailModel.setCc(Collections.singletonList("cc1@example.com"));
        emailModel.setBcc(Collections.singletonList("bcc1@example.com"));
        emailModel.setEmailSendingStates(Collections.singletonList(createBounceEmailSendingStateModel()));
        return emailModel;
    }

    public EmailWithAttachmentsModel createEmailWithAttachmentsModel() {
        final EmailWithAttachmentsModel emailModel = new EmailWithAttachmentsModel();
        emailModel.setTo("arthur.asatryan@sflpro.com");
        emailModel.setFrom("biacoder@gmail.com");
        emailModel.setSubject("Test subject");
        emailModel.setContent("Test content");
        emailModel.setCc(Collections.singletonList("cc1@example.com"));
        emailModel.setBcc(Collections.singletonList("bcc1@example.com"));
        emailModel.setEmailSendingStates(Collections.singletonList(createBounceEmailSendingStateModel()));
        emailModel.setAttachments(Collections.emptyList());
        return emailModel;
    }

    public EmailModel createEmailModel(final AbstractEmailSendingStateModel... sendingStateModel) {
        final EmailModel emailModel = new EmailModel();
        emailModel.setTo("arthur.asatryan@sflpro.com");
        emailModel.setFrom("biacoder@gmail.com");
        emailModel.setSubject("Test subject");
        emailModel.setContent("Test content");
        emailModel.setCc(Collections.singletonList("cc1@example.com"));
        emailModel.setBcc(Collections.singletonList("bcc1@example.com"));
        emailModel.setEmailSendingStates(Arrays.asList(sendingStateModel));
        return emailModel;
    }
    //endregion

    //region Sending state
    public BounceEmailSendingStateModel createBounceEmailSendingStateModel() {
        final BounceEmailSendingStateModel model = new BounceEmailSendingStateModel();
        model.setEmailUuid(UUID.randomUUID().toString());
        model.setEmailUuid("arthur.asatryan@sflpro.com");
        return model;
    }

    public ClickEmailSendingStateModel createClickEmailSendingStateModel() {
        final ClickEmailSendingStateModel model = new ClickEmailSendingStateModel();
        model.setEmailUuid(UUID.randomUUID().toString());
        model.setEmailUuid("arthur.asatryan@sflpro.com");
        return model;
    }

    public UpdateEmailSendingStatesRequest createUpdateEmailSendingStateRequest() {
        return createUpdateEmailSendingStateRequest(createBounceEmailSendingStateModel());
    }

    public UpdateEmailSendingStatesRequest createUpdateEmailSendingStateRequest(final AbstractEmailSendingStateModel model) {
        return new UpdateEmailSendingStatesRequest(new ArrayList<>(Arrays.asList(model)));
    }
    //endregion

    //region File info
    public StoredFileInfoModel createStoredFileInfoModel(final String uuid) {
        return new StoredFileInfoModel(uuid, "file name.dat", "dat", new Date());
    }
    //endregion

    //endregion

    //region Utility methods
    //endregion
}
