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
import com.sfl.coolmonkey.notifications.facade.common.component.CommonMailRequestAssertionComponent;
import com.sfl.coolmonkey.notifications.facade.email.EmailFacade;
import com.sfl.coolmonkey.notifications.facade.email.component.EmailAttachmentComponent;
import com.sfl.coolmonkey.notifications.facade.test.AbstractFacadeImplTest;
import com.sfl.coolmonkey.notifications.queue.producer.email.EmailSendingProducer;
import com.sfl.coolmonkey.notifications.service.email.EmailService;
import com.sfl.coolmonkey.notifications.service.email.dto.CreateEmailDto;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.SerializationUtils;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 1/12/16
 * Time: 6:43 PM
 */
public class EmailFacadeImplTest extends AbstractFacadeImplTest {

    //region Test subject and mocks
    @TestSubject
    private EmailFacade emailFacade = new EmailFacadeImpl();

    @Mock
    private EmailService emailService;

    @Mock
    private MapperFacade mapperFacade;

    @Mock
    private EmailSendingProducer emailSendingProducer;

    @Mock
    private CommonMailRequestAssertionComponent commonMailRequestAssertionComponent;

    @Mock
    private EmailAttachmentComponent emailAttachmentComponent;
    //endregion

    //region Constructors
    public EmailFacadeImplTest() {
    }
    //endregion

    //region Test methods

    //region send
    @Test
    public void testSend() {
        // Test data
        final EmailRequest request = new EmailRequest(getHelper().createEmailModel());
        final CreateEmailDto dto = getHelper().createEmailCreationDto();
        final Email email = getHelper().createEmail();
        final EmailModel model = getHelper().createEmailModel();
        // Reset
        resetAll();
        // Expectations
        commonMailRequestAssertionComponent.assertCommonMailRequest(request);
        expect(mapperFacade.map(request.getEmail(), CreateEmailDto.class)).andReturn(dto);
        expect(emailService.create(dto)).andReturn(email);
        emailSendingProducer.produceEmailSendingEvent(email.getUuid());
        expect(mapperFacade.map(email, EmailModel.class)).andReturn(model);
        // Replay
        replayAll();
        // Run test scenario
        final ResultResponseModel<EmailResponse> result = emailFacade.send(request);
        assertNotNull(result);
        assertFalse(result.hasErrors());
        assertNotNull(result.getResponse());
        assertEquals(result.getResponse().getEmail(), model);
        // Verify
        verifyAll();
    }
    //endregion

    //region updateStates
    @Test
    public void testUpdateStatesWithInvalidArguments() {
        // Test data
        final UpdateEmailSendingStatesRequest validRequest = getHelper().createUpdateEmailSendingStateRequest();
        UpdateEmailSendingStatesRequest invalidRequest;
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();
        // Run test scenario
        // the request should not be null
        invalidRequest = null;
        try {
            emailFacade.updateStates(invalidRequest);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        // the list of models should not be null
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.setModels(null);
        try {
            emailFacade.updateStates(invalidRequest);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        // the list of models should not be empty
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.setModels(Collections.emptyList());
        try {
            emailFacade.updateStates(invalidRequest);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        // the list of models should not contain null element
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.getModels().add(null);
        try {
            emailFacade.updateStates(invalidRequest);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        // Verify
        verifyAll();
    }
    //endregion

    //region getByUuids
    @Test
    public void testGetByUuidsWithInvalidArguments() {
        // Test data
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();
        // Run test scenario
        try {
            emailFacade.getByUuids(new GetEmailsByUuidsRequest(null));
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        try {
            emailFacade.getByUuids(new GetEmailsByUuidsRequest(Collections.singletonList(null)));
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        // Verify
        verifyAll();
    }

    @Test
    public void testGetByUuids() {
        // Test data
        final List<Email> emails = Collections.singletonList(getHelper().createEmail());
        final List<String> uuids = emails.stream().map(Email::getUuid).collect(Collectors.toList());
        final GetEmailsByUuidsRequest request = new GetEmailsByUuidsRequest(uuids);
        final List<EmailWithAttachmentsModel> emailModels = Collections.singletonList(getHelper().createEmailWithAttachmentsModel());
        final List<EmailWithAttachmentsModel> mappedModels = Collections.singletonList(getHelper().createEmailWithAttachmentsModel());
        // Reset
        resetAll();
        // Expectations
        expect(emailService.getByUuids(uuids)).andReturn(emails);
        expect(mapperFacade.mapAsList(emails, EmailWithAttachmentsModel.class)).andReturn(emailModels);
        expect(emailAttachmentComponent.mapAttachmentNames(emailModels)).andReturn(mappedModels);
        // Replay
        replayAll();
        // Run test scenario
        final ResultResponseModel<GetEmailsByUuidsResponse> result = emailFacade.getByUuids(request);
        getHelper().assertResultResponseModel(result);
        assertNotNull(result.getResponse());
        assertEquals(result.getResponse().getEmails(), mappedModels);
        // Verify
        verifyAll();
    }
    //endregion

    //region getByUuid
    @Test
    public void testGetByUuid() {
        // Test data
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();
        // Run test scenario
        try {
            emailFacade.getByUuid(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
        }
        try {
            emailFacade.getByUuid(new GetEmailByUuidRequest(null));
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ignore) {
        }
        // Verify
        verifyAll();
    }

    @Test
    public void testGetByEmailUuid() {
        // Test data
        final Email email = getHelper().createEmail();
        final String uuid = email.getUuid();
        final GetEmailByUuidRequest request = new GetEmailByUuidRequest(uuid);
        final EmailModel emailModel = getHelper().createEmailModel();
        // Reset
        resetAll();
        // Expectations
        expect(emailService.getByUuid(request.getUuid())).andReturn(email);
        expect(mapperFacade.map(email, EmailModel.class)).andReturn(emailModel);
        // Replay
        replayAll();
        // Run test scenario
        final ResultResponseModel<GetEmailByUuidResponse> result = emailFacade.getByUuid(request);
        assertNotNull(result);
        assertFalse(result.hasErrors());
        assertEquals(emailModel, result.getResponse().getEmail());
        // Verify
        verifyAll();
    }
    //endregion

    //endregion

    //region Utility methods
    //endregion
}