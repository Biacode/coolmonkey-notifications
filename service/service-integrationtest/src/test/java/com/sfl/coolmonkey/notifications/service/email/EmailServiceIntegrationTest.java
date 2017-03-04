package com.sfl.coolmonkey.notifications.service.email;

import com.sfl.coolmonkey.notifications.persistence.repositories.email.EmailRepository;
import com.sfl.coolmonkey.notifications.service.email.dto.CreateEmailDto;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import com.sfl.coolmonkey.notifications.service.email.model.aggregation.AbstractEmailSendingState;
import com.sfl.coolmonkey.notifications.service.test.AbstractServiceIntegrationTest;
import org.bson.types.ObjectId;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/18/15
 * Time: 1:45 PM
 */
@Component
public class EmailServiceIntegrationTest extends AbstractServiceIntegrationTest {

    //region Dependencies
    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailRepository emailRepository;
    //endregion

    //region Constructors
    public EmailServiceIntegrationTest() {
    }
    //endregion

    //region Tes methods
    @Test
    public void testGetById() {
        // prepare data
        final Email email = getHelper().createAndPersistEmail();
        final ObjectId id = email.getId();
        // run test scenario
        final Email result = emailService.getById(id);
        assertNotNull(result);
        assertEquals(email, result);
    }

    @Test
    public void testBetByUuid() {
        // prepare data
        final Email email = getHelper().createAndPersistEmail();
        final String uuid = email.getUuid();
        // run test scenario
        final Email result = emailService.getByUuid(uuid);
        assertNotNull(result);
        assertEquals(email, result);
    }

    @Test
    public void testCreate() {
        // prepare data
        final CreateEmailDto dto = getHelper().createEmailCreationDto();
        // run test scenario
        final Email email = emailService.create(dto);
        assertEmailDto(dto, email);
        final Email result = emailService.getById(email.getId());
        assertEquals(email, result);
    }

    @Test
    public void testAddEmailSendingState() {
        // prepare data
        final Email email = getHelper().createAndPersistEmail();
        final AbstractEmailSendingState emailSendingState = getHelper().createBounceEmailSendingState();
        // run test scenario
        final Email result = emailService.addEmailSendingState(email.getUuid(), emailSendingState);
        assertNotNull(result);
        assertTrue(result.getEmailSendingStates().contains(emailSendingState));
        assertNotEquals(email.getUpdated(), result.getUpdated());
    }

    @Test
    public void getByUuidList() {
        // prepare data
        final List<Email> emails = new ArrayList<>(Collections.singletonList(getHelper().createAndPersistEmail()));
        final Email secondEmail = getHelper().createAndPersistEmail();
        secondEmail.setRemoved(new Date());
        final Email removedEmail = emailRepository.save(secondEmail);
        emails.add(removedEmail);
        final List<String> uuids = emails.stream().map(Email::getUuid).collect(Collectors.toList());
        // run test scenario
        final List<Email> result = emailService.getByUuids(uuids);
        assertNotNull(result);
        assertTrue(result.size() == 1);
        assertFalse(result.contains(removedEmail));
        result.forEach(emails::contains);
    }
    //endregion

    //region Utility methods
    private void assertEmailDto(final CreateEmailDto dto, final Email result) {
        assertNotNull(dto);
        assertNotNull(result);
        assertEquals(dto.getTo(), result.getTo());
        assertEquals(dto.getFrom(), result.getFrom());
        assertEquals(dto.getSubject(), result.getSubject());
        assertEquals(dto.getContent(), result.getContent());
        assertEquals(dto.getCc(), result.getCc());
        assertEquals(dto.getBcc(), result.getBcc());
        assertEquals(dto.getReplyEmail(), result.getReplyEmail());
        assertEquals(dto.getOrigin(), result.getOrigin());
    }
    //endregion
}
