package com.sfl.coolmonkey.notifications.service.email.impl;

import com.sfl.coolmonkey.notifications.persistence.repositories.email.EmailRepository;
import com.sfl.coolmonkey.notifications.service.common.component.CommonAssertionComponent;
import com.sfl.coolmonkey.notifications.service.email.EmailService;
import com.sfl.coolmonkey.notifications.service.email.dto.CreateEmailDto;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import com.sfl.coolmonkey.notifications.service.email.model.aggregation.AbstractEmailSendingState;
import com.sfl.coolmonkey.notifications.service.test.AbstractServiceImplTest;
import org.apache.commons.lang3.SerializationUtils;
import org.bson.types.ObjectId;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Test;
import org.springframework.util.Assert;

import javax.annotation.Nonnull;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/18/15
 * Time: 11:37 AM
 */
public class EmailServiceImplTest extends AbstractServiceImplTest {

    //region Test subject and mocks
    @TestSubject
    private EmailService emailService = new EmailServiceImpl();

    @Mock
    private EmailRepository emailRepository;

    @Mock
    private CommonAssertionComponent commonAssertionComponent;
    //endregion

    //region Constructors
    public EmailServiceImplTest() {
    }
    //endregion

    //region Test methods

    //region getById
    @Test
    public void testGetById() {
        // Test data
        final ObjectId id = new ObjectId();
        final Email email = getHelper().createEmail();
        email.setId(id);
        // Reset
        resetAll();
        // Expectations
        commonAssertionComponent.assertObjectIdNotNull(id);
        expect(emailRepository.findOne(id)).andReturn(email);
        commonAssertionComponent.assertDomainModelNotNullForId(id, email);
        // Replay
        replayAll();
        // Run test scenario
        final Email result = emailService.getById(id);
        assertNotNull(result);
        assertEquals(email, result);
        // Verify
        verifyAll();
    }
    //endregion

    //region getByUuid
    @Test
    public void testGetByUuid() {
        // Test data
        final Email email = getHelper().createEmail();
        final String uuid = email.getUuid();
        // Reset
        resetAll();
        // Expectations
        commonAssertionComponent.assertUuidNotBlank(uuid);
        expect(emailRepository.findByUuid(uuid)).andReturn(email);
        commonAssertionComponent.assertDomainModelNotNullForUuid(uuid, email);
        // Replay
        replayAll();
        // Run test scenario
        final Email result = emailService.getByUuid(uuid);
        assertNotNull(result);
        assertEquals(email, result);
        // Verify
        verifyAll();
    }
    //endregion

    //region create
    @Test
    public void testCreate() {
        // Test data
        final CreateEmailDto dto = getHelper().createEmailCreationDto();
        // Reset
        resetAll();
        // Expectations
        assertCreateEmailDto(dto);
        expect(emailRepository.save(isA(Email.class))).andAnswer(() -> (Email) getCurrentArguments()[0]);
        // Replay
        replayAll();
        // Run test scenario
        final Email result = emailService.create(dto);
        assertEmailDto(dto, result);
        // Verify
        verifyAll();
    }
    //endregion

    //region addEmailSendingState
    @Test
    public void testAddEmailSendingState() {
        // Test data
        final Email email = getHelper().createEmail();
        final String uuid = email.getUuid();
        final AbstractEmailSendingState emailSendingState = getHelper().createBounceEmailSendingState();
        final Email updatedEmail = SerializationUtils.clone(email);
        updatedEmail.getEmailSendingStates().add(emailSendingState);
        // Reset
        resetAll();
        // Expectations
        commonAssertionComponent.assertUuidNotBlank(uuid);
        expectLastCall().times(2);
        assertEmailSendingState(emailSendingState);
        expect(emailRepository.findByUuid(uuid)).andReturn(email);
        commonAssertionComponent.assertDomainModelNotNullForUuid(uuid, email);
        expect(emailRepository.save(isA(Email.class))).andReturn(updatedEmail);
        // Replay
        replayAll();
        // Run test scenario
        final Email result = emailService.addEmailSendingState(uuid, emailSendingState);
        assertNotNull(result);
        assertEquals(email.getEmailSendingStates(), updatedEmail.getEmailSendingStates());
        assertNotEquals(email.getUpdated(), result.getUpdated());
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
            emailService.getByUuids(null);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        try {
            emailService.getByUuids(Collections.singletonList(null));
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        // Verify
        verifyAll();
    }

    @Test
    public void testGetByUuidList() {
        // Test data
        final List<Email> emails = Collections.singletonList(getHelper().createEmail());
        final List<String> uuids = emails.stream().map(Email::getUuid).collect(Collectors.toList());
        // Reset
        resetAll();
        // Expectations
        expect(emailRepository.findByUuidInAndRemovedIsNull(uuids)).andReturn(emails);
        // Replay
        replayAll();
        // Run test scenario
        final List<Email> result = emailService.getByUuids(uuids);
        assertNotNull(result);
        assertEquals(emails, result);
        // Verify
        verifyAll();
    }
    //endregion

    //endregion

    //region Utility methods
    private void assertEmailDto(final CreateEmailDto dto, final Email result) {
        assertNotNull(dto);
        assertNotNull(result);
        assertEquals(dto.getTo(), result.getTo());
        assertEquals(dto.getFrom(), result.getFrom());
        assertEquals(dto.getSenderName(), result.getSenderName());
        assertEquals(dto.getContent(), result.getContent());
        assertEquals(dto.getCc(), result.getCc());
        assertEquals(dto.getBcc(), result.getBcc());
        assertEquals(dto.getReplyEmail(), result.getReplyEmail());
        assertEquals(dto.getOrigin(), result.getOrigin());
    }

    private void assertCreateEmailDto(@Nonnull final CreateEmailDto dto) {
        Assert.notNull(dto);
        Assert.hasText(dto.getTo());
        Assert.hasText(dto.getFrom());
        Assert.hasText(dto.getContent());
    }

    private void assertEmailSendingState(final AbstractEmailSendingState state) {
        Assert.notNull(state);
    }
    //endregion
}