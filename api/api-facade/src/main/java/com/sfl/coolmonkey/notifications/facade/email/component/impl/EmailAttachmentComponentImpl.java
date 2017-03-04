package com.sfl.coolmonkey.notifications.facade.email.component.impl;

import com.sfl.coolmonkey.coolfs.api.model.storage.StoredFileInfoModel;
import com.sfl.coolmonkey.coolfs.api.model.storage.request.GetFileInfoByUuidListRequest;
import com.sfl.coolmonkey.notifications.api.model.email.AttachmentModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailWithAttachmentsModel;
import com.sfl.coolmonkey.notifications.externalclients.coolfs.communicator.CoolFsServiceCommunicator;
import com.sfl.coolmonkey.notifications.facade.email.component.EmailAttachmentComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * User: Ruben Vardanyan
 * Company: SFL LLC
 * Date: 3/24/16
 * Time: 3:40 PM
 */
@Component
public class EmailAttachmentComponentImpl implements EmailAttachmentComponent {
    private static final Logger LOGGER = LoggerFactory.getLogger(EmailAttachmentComponentImpl.class);

    //region Dependencies
    @Autowired
    private CoolFsServiceCommunicator coolFsServiceCommunicator;
    //endregion

    //region Constructor
    public EmailAttachmentComponentImpl() {
        LOGGER.debug("Initializing email attachment model");
    }
    //endregion

    //region Public methods
    @Nonnull
    @Override
    public List<EmailWithAttachmentsModel> mapAttachmentNames(@Nonnull final List<EmailWithAttachmentsModel> models) {
        Assert.notNull(models);
        Assert.noNullElements(models.toArray());
        final List<String> attachmentUuids = new ArrayList<>();
        models.stream()
                .filter(email -> email.getAttachments() != null && !email.getAttachments().isEmpty())
                .forEach(email -> email.getAttachments().forEach(attachmentModel -> attachmentUuids.add(attachmentModel.getUuid())));
        final List<StoredFileInfoModel> filesInfo = coolFsServiceCommunicator.getFileInfoByUuids(new GetFileInfoByUuidListRequest(attachmentUuids)).getResponse().getFilesInfo();
        for (EmailWithAttachmentsModel model : models) {
            if (model.getAttachments() == null || model.getAttachments().isEmpty()) {
                continue;
            }
            for (AttachmentModel attachmentModel : model.getAttachments()) {
                final Optional<StoredFileInfoModel> fileInfo = filesInfo.stream().filter(info -> info.getUuid().equals(attachmentModel.getUuid())).findAny();
                fileInfo.ifPresent(storedFileInfoModel -> attachmentModel.setName(storedFileInfoModel.getFileName()));
            }
        }
        return models;
    }
    //endregion
}
