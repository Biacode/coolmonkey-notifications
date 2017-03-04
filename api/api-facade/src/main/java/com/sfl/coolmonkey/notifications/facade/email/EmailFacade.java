package com.sfl.coolmonkey.notifications.facade.email;

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
 * Time: 6:31 PM
 */
public interface EmailFacade {
    /**
     * Send result response model.
     *
     * @param request the request
     * @return the result response model
     */
    @Nonnull
    ResultResponseModel<EmailResponse> send(@Nonnull final EmailRequest request);

    /**
     * Update states email states and returns failed emails uuids.
     * <p>E.g. BOUNCE, DROPPED, DEFERRED</p>
     *
     * @param request the request
     * @return the result response model
     */
    @Nonnull
    ResultResponseModel<UpdateEmailSendingStatesResponse> updateStates(@Nonnull final UpdateEmailSendingStatesRequest request);

    /**
     * Gets by uuids.
     *
     * @param request the request
     * @return the by uuids
     */
    @Nonnull
    ResultResponseModel<GetEmailsByUuidsResponse> getByUuids(@Nonnull final GetEmailsByUuidsRequest request);

    /**
     * Gets by uuid.
     *
     * @param request the request
     * @return the by uuid
     */
    @Nonnull
    ResultResponseModel<GetEmailByUuidResponse> getByUuid(@Nonnull final GetEmailByUuidRequest request);
}
