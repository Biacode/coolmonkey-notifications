package com.sfl.coolmonkey.notifications.api.rest.resources.email;

import com.sfl.coolmonkey.notifications.api.model.email.request.EmailRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.GetEmailByUuidRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.GetEmailsByUuidsRequest;
import com.sfl.coolmonkey.notifications.api.model.email.request.UpdateEmailSendingStatesRequest;
import com.sfl.coolmonkey.notifications.api.rest.resources.helper.ResourceHelper;
import com.sfl.coolmonkey.notifications.facade.email.EmailFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/12/16
 * Time: 6:29 PM
 */
@Component
@Path("email")
@Consumes("application/json")
@Produces("application/json")
public class EmailResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmailResource.class);

    //region Dependencies
    @Autowired
    private EmailFacade emailFacade;
    //endregion

    //region Constructors
    public EmailResource() {
        LOGGER.debug("Initializing email resource");
    }
    //endregion

    //region Public methods
    @POST
    public Response send(final EmailRequest request) {
        ResourceHelper.assertRequestNotNull(request);
        return Response.ok(emailFacade.send(request)).build();
    }

    @POST
    @Path("update-states")
    public Response updateStates(final UpdateEmailSendingStatesRequest request) {
        ResourceHelper.assertRequestNotNull(request);
        return Response.ok(emailFacade.updateStates(request)).build();
    }

    @POST
    @Path("get-by-uuids")
    public Response getByUuids(final GetEmailsByUuidsRequest request) {
        ResourceHelper.assertRequestNotNull(request);
        return Response.ok(emailFacade.getByUuids(request)).build();
    }

    @GET
    public Response getByUuid(@BeanParam final GetEmailByUuidRequest request) {
        ResourceHelper.assertRequestNotNull(request);
        return Response.ok(emailFacade.getByUuid(request)).build();
    }

    @GET
    @Path("/heartbeat")
    public Response getHeartBeat() {
        return Response.ok("OK").build();
    }
    ///endregion
}
