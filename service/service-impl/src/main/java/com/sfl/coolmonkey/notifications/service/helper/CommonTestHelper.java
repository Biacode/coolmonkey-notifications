package com.sfl.coolmonkey.notifications.service.helper;

import com.sfl.coolmonkey.notifications.service.email.dto.CreateEmailDto;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import com.sfl.coolmonkey.notifications.service.email.model.EmailOrigin;
import com.sfl.coolmonkey.notifications.service.email.model.aggregation.BounceEmailSendingState;

import java.util.*;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 8/21/15
 * Time: 11:24 AM
 */
@SuppressWarnings({
        "MagicNumber",
        "DuplicateStringLiteralInspection",
        "checkstyle:com.puppycrawl.tools.checkstyle.checks.coding.MagicNumberCheck",
        "pmd:AvoidDuplicateLiterals",
        "squid:S1192"
})
public class CommonTestHelper {

    //region Constants
    private static final int TESTABLE_COUNT = 3;
    //endregion

    //region Constructors
    public CommonTestHelper() {
    }
    //endregion

    //region Public methods

    //region Email
    public CreateEmailDto createEmailCreationDto() {
        return new CreateEmailDto(
                "biacoder@gmail.com",
                "arthur.asatryan@sflpro.com",
                "Arthur",
                "replyemail@example.com",
                "Test subject",
                "Test content",
                Collections.singletonList(UUID.randomUUID().toString()),
                createCcList(),
                createBccList(),
                EmailOrigin.ADDRESS_DISPOSITION
        );
    }

    public Email createEmail() {
        final Email email = new Email();
        email.setTo("arthur.asatryan@sflpro.com");
        email.setFrom("biacoder@gmail.com");
        email.setReplyEmail("replyemail@example.com");
        email.setSubject("Test subject");
        email.setContent("<p>Test HTML content</p>");
        email.setCc(createCcList());
        email.setBcc(createBccList());
        // DO NOT CHANGE IT TO Collections.singletonList, because otherwise you will not be able to append state to list
        email.setEmailSendingStates(new ArrayList<>(Arrays.asList(createBounceEmailSendingState())));
        return email;
    }

    public List<String> createCcList() {
        return createCcList(TESTABLE_COUNT);
    }

    public List<String> createCcList(final int count) {
        final List<String> ccList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            ccList.add("cc" + i + "@example.com");
        }
        return ccList;
    }

    public List<String> createBccList() {
        return createBccList(TESTABLE_COUNT);
    }

    public List<String> createBccList(final int count) {
        final List<String> bccList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            bccList.add("bcc" + i + "@example.com");
        }
        return bccList;
    }
    //endregion

    //region Sending state
    public BounceEmailSendingState createBounceEmailSendingState() {
        return createBounceEmailSendingState("arthur.asatryan@sflpro.com");
    }

    public BounceEmailSendingState createBounceEmailSendingState(final String email) {
        final BounceEmailSendingState emailSendingState = new BounceEmailSendingState();
        emailSendingState.setEmail(email);
        return emailSendingState;
    }
    //endregion

    //endregion
}
