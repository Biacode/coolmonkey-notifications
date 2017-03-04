package com.sfl.coolmonkey.notifications.service.helper;

import com.sfl.coolmonkey.notifications.service.email.EmailService;
import com.sfl.coolmonkey.notifications.service.email.dto.CreateEmailDto;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 7/3/15
 * Time: 4:07 PM
 */
@Component
public class ServiceIntegrationTestHelper extends CommonTestHelper {

    //region Dependencies
    @Autowired
    private EmailService emailService;
    //endregion

    //region Constructors
    public ServiceIntegrationTestHelper() {
    }
    //endregion

    //region Public methods
    public Email createAndPersistEmail() {
        return createAndPersistEmail(createEmailCreationDto());
    }

    public Email createAndPersistEmail(final CreateEmailDto dto) {
        return emailService.create(dto);
    }
    //endregion
}
