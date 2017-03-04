package com.sfl.coolmonkey.notifications.facade.common.component.impl;

import com.sfl.coolmonkey.notifications.api.model.email.EmailModel;
import com.sfl.coolmonkey.notifications.api.model.email.request.EmailRequest;
import com.sfl.coolmonkey.notifications.facade.common.component.CommonMailRequestAssertionComponent;
import com.sfl.coolmonkey.notifications.facade.test.AbstractFacadeImplTest;
import org.apache.commons.lang3.SerializationUtils;
import org.easymock.TestSubject;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 12/21/15
 * Time: 7:08 PM
 */
public class CommonMailRequestAssertionComponentImplTest extends AbstractFacadeImplTest {

    //region Test subject and mocks
    @TestSubject
    private CommonMailRequestAssertionComponent commonMailRequestAssertionComponent = new CommonMailRequestAssertionComponentImpl();
    //endregion

    //region Constructors
    public CommonMailRequestAssertionComponentImplTest() {
    }
    //endregion

    //region Test methods
    @Test
    public void testAssertCommonMailRequestWithAssertionErrors() {
        // Test data
        final EmailModel emailModel = getHelper().createEmailModel();
        final EmailRequest validRequest = new EmailRequest(emailModel);
        EmailRequest invalidRequest;
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();
        // Run test scenario
        invalidRequest = null;
        try {
            commonMailRequestAssertionComponent.assertCommonMailRequest(invalidRequest);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.getEmail().setTo(null);
        try {
            commonMailRequestAssertionComponent.assertCommonMailRequest(invalidRequest);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        invalidRequest = SerializationUtils.clone(validRequest);
        invalidRequest.getEmail().setFrom(null);
        try {
            commonMailRequestAssertionComponent.assertCommonMailRequest(invalidRequest);
            fail("Exception should be thrown");
        } catch (final IllegalArgumentException ex) {
            // Expected
        }
        // Verify
        verifyAll();
    }

    @Test
    public void testAssertCommonMailRequest() {
        // Test data
        final EmailModel emailModel = getHelper().createEmailModel();
        emailModel.setContent(null);
        final EmailRequest request = new EmailRequest(emailModel);
        // Reset
        resetAll();
        // Expectations
        // Replay
        replayAll();
        // Run test scenario
        commonMailRequestAssertionComponent.assertCommonMailRequest(request);
        // Verify
        verifyAll();
    }
    //endregion
}