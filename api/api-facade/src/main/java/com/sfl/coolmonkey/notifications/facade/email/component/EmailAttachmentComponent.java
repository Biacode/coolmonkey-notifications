package com.sfl.coolmonkey.notifications.facade.email.component;

import com.sfl.coolmonkey.notifications.api.model.email.EmailWithAttachmentsModel;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * User: Ruben Vardanyan
 * Company: SFL LLC
 * Date: 3/24/16
 * Time: 3:39 PM
 */
public interface EmailAttachmentComponent {

    @Nonnull
    List<EmailWithAttachmentsModel> mapAttachmentNames(@Nonnull final List<EmailWithAttachmentsModel> models);

}
