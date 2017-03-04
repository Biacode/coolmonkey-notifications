package com.sfl.coolmonkey.notifications.api.client.rest.email.impl;

import com.sfl.coolmonkey.commons.api.model.request.AbstractRequestModel;
import com.sfl.coolmonkey.commons.api.model.response.ResultResponseModel;
import com.sfl.coolmonkey.notifications.api.client.rest.common.AbstractResourceClient;
import com.sfl.coolmonkey.notifications.api.client.rest.email.EmailResourceClient;
import com.sfl.coolmonkey.notifications.api.model.email.request.EmailRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.GetEmailByUuidRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.GetEmailsByUuidsRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.UpdateEmailSendingStatesRequest;
import com.sfl.coolmonkey.notifications.api.model.email.response.EmailResponse;
import com.sfl.coolmonkey.notifications.api.model.email.response.GetEmailByUuidResponse;
import com.sfl.coolmonkey.notifications.api.model.email.response.GetEmailsByUuidsResponse;
import com.sfl.coolmonkey.notifications.api.model.email.response.UpdateEmailSendingStatesResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/12/16
 * Time: 6:56 PM
 */
public class EmailResourceClientImpl extends AbstractResourceClient implements EmailResourceClient {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailResourceClientImpl.class);

    //region Constants
    private static final String RESOURCE_BASE_PATH = "email";

    private static final String UPDATE_STATES_PATH = "update-states";

    private static final String GET_BY_UUIDS = "get-by-uuids";
    //endregion

    //region Constructors
    public EmailResourceClientImpl(final Client client, final String apiPath) {
        super(client, apiPath);
        LOGGER.debug("Initializing email resource client");
    }
    //endregion

    //region Public methods
    @Nonnull
    @Override
    public ResultResponseModel<EmailResponse> send(@Nonnull final EmailRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE), new GenericType<ResultResponseModel<EmailResponse>>() {
                });
    }

    @Nonnull
    @Override
    public ResultResponseModel<UpdateEmailSendingStatesResponse> updateStates(@Nonnull final UpdateEmailSendingStatesRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .path(UPDATE_STATES_PATH)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE), new GenericType<ResultResponseModel<UpdateEmailSendingStatesResponse>>() {
                });
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetEmailsByUuidsResponse> getByUuids(@Nonnull final GetEmailsByUuidsRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .path(GET_BY_UUIDS)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.entity(request, MediaType.APPLICATION_JSON_TYPE), new GenericType<ResultResponseModel<GetEmailsByUuidsResponse>>() {
                });
    }

    @Nonnull
    @Override
    public ResultResponseModel<GetEmailByUuidResponse> getByUuid(@Nonnull final GetEmailByUuidRequest request) {
        assertRequestNotNull(request);
        return getClient()
                .target(getApiPath())
                .path(RESOURCE_BASE_PATH)
                .queryParam("uuid", request.getUuid())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get(new GenericType<ResultResponseModel<GetEmailByUuidResponse>>() {
                });
    }
    //endregion

    //region Utility methods
    private void assertRequestNotNull(final AbstractRequestModel request) {
        Assert.notNull(request, "Request should not be null");
    }
    //endregion
}
