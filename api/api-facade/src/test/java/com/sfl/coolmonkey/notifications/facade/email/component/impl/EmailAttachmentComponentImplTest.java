package com.sfl.coolmonkey.notifications.facade.email.component.impl;

import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.coolfs.api.model.storage.StoredFileInfoModel;
import com.sfl.coolmonkey.coolfs.api.model.storage.request.GetFileInfoByUuidListRequest;
import com.sfl.coolmonkey.coolfs.api.model.storage.response.GetFileInfoByUuidListResponse;
import com.sfl.coolmonkey.notifications.api.model.email.AttachmentModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailWithAttachmentsModel;
import com.sfl.coolmonkey.notifications.externalclients.coolfs.communicator.CoolFsServiceCommunicator;
import com.sfl.coolmonkey.notifications.facade.email.component.EmailAttachmentComponent;
import com.sfl.coolmonkey.notifications.facade.test.AbstractFacadeImplTest;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * User: Ruben Vardanyan
 * Company: SFL LLC
 * Date: 3/24/16
 * Time: 3:48 PM
 */
public class EmailAttachmentComponentImplTest extends AbstractFacadeImplTest {

    //region Test subject and mocks
    @TestSubject
    private EmailAttachmentComponent emailAttachmentComponent = new EmailAttachmentComponentImpl();

    @Mock
    private CoolFsServiceCommunicator coolFsServiceCommunicator;
    //endregion

    //region Constructor
    public EmailAttachmentComponentImplTest() {
    }
    //endregion

    //region Test methods

    //region mapAttachmentNames

    @Test
    public void testMapAttachmentNamesWithInvalidArguments() {
        // Test data
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();
        // Run test scenario
        try {
            emailAttachmentComponent.mapAttachmentNames(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
        }
        try {
            emailAttachmentComponent.mapAttachmentNames(Arrays.asList(getHelper().createEmailWithAttachmentsModel(), null));
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
        }
        // Verify
        verifyAll();
    }

    @Test
    public void testMapAttachmentNames() {
        // Test data
        final EmailWithAttachmentsModel emailWithAttachmentsModel = getHelper().createEmailWithAttachmentsModel();
        final String attachmentUuid = UUID.randomUUID().toString();
        emailWithAttachmentsModel.setAttachments(Collections.singletonList(new AttachmentModel(attachmentUuid, null)));
        final List<EmailWithAttachmentsModel> models = Collections.singletonList(emailWithAttachmentsModel);
        final StoredFileInfoModel storedFileInfoModel = getHelper().createStoredFileInfoModel(attachmentUuid);
        // Reset
        resetAll();
        // Expectations
        expect(coolFsServiceCommunicator.getFileInfoByUuids(new GetFileInfoByUuidListRequest(Collections.singletonList(attachmentUuid))))
                .andReturn(new ResultResponseModel<>(new GetFileInfoByUuidListResponse(Collections.singletonList(storedFileInfoModel))));
        // Replay
        replayAll();
        // Run test scenario
        final List<EmailWithAttachmentsModel> result = emailAttachmentComponent.mapAttachmentNames(models);
        // Verify
        verifyAll();
        assertEquals(models.size(), result.size());
        assertEquals(models.get(0).getAttachments().size(), result.get(0).getAttachments().size());
        assertEquals(storedFileInfoModel.getFileName(), result.get(0).getAttachments().get(0).getName());
    }

    //endregion

    //endregion

}