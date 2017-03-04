package com.sfl.coolmonkey.notifications.api.client.rest.email;

import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.notifications.api.model.email.request.EmailRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.GetEmailByUuidRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.GetEmailsByUuidsRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.UpdateEmailSendingStatesRequest;
import com.sfl.coolmonkey.notifications.api.model.email.response.EmailResponse;
import com.sfl.coolmonkey.notifications.api.model.email.response.GetEmailByUuidResponse;
import com.sfl.coolmonkey.notifications.api.model.email.response.GetEmailsByUuidsResponse;
import com.sfl.coolmonkey.notifications.api.model.email.response.UpdateEmailSendingStatesResponse;

import javax.annotation.Nonnull;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/12/16
 * Time: 6:55 PM
 */
public interface EmailResourceClient {
    @Nonnull
    ResultResponseModel<EmailResponse> send(@Nonnull final EmailRequest request);

    @Nonnull
    ResultResponseModel<UpdateEmailSendingStatesResponse> updateStates(@Nonnull final UpdateEmailSendingStatesRequest request);

    @Nonnull
    ResultResponseModel<GetEmailsByUuidsResponse> getByUuids(@Nonnull final GetEmailsByUuidsRequest request);

    @Nonnull
    ResultResponseModel<GetEmailByUuidResponse> getByUuid(@Nonnull final GetEmailByUuidRequest request);
}
