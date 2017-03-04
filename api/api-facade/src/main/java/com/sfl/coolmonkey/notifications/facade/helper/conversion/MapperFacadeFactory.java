package com.sfl.coolmonkey.notifications.facade.helper.conversion;

import com.sfl.coolmonkey.notifications.api.model.email.EmailModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailOriginModel;
import com.sfl.coolmonkey.notifications.api.model.email.EmailWithAttachmentsModel;
import com.sfl.coolmonkey.notifications.api.model.email.aggregation.*;
import com.sfl.coolmonkey.notifications.facade.helper.conversion.emailsendingstate.AbstractEmailSendingStateModelToAbstractEmailSendingStateConverter;
import com.sfl.coolmonkey.notifications.service.email.dto.CreateEmailDto;
import com.sfl.coolmonkey.notifications.service.email.model.Email;
import com.sfl.coolmonkey.notifications.service.email.model.EmailOrigin;
import com.sfl.coolmonkey.notifications.service.email.model.aggregation.*;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.config.AbstractFactoryBean;
import org.springframework.stereotype.Component;

/**
 * User: Babken Vardanyan
 * Company: SFL LLC
 * Date: 10/1/15
 * Time: 6:48 PM
 */
@Component
@SuppressWarnings({
        "pmd:NcssMethodCount",
        "squid:S138",
})
public class MapperFacadeFactory extends AbstractFactoryBean<MapperFacade> {

    //region Constructors
    public MapperFacadeFactory() {
    }
    //endregion

    //region Public methods
    @Override
    public Class<?> getObjectType() {
        return MapperFacade.class;
    }

    @Override
    public MapperFacade createInstance() {
        final MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();
        initEmailMappings(mapperFactory);
        initEmailSendingStateMappings(mapperFactory);
        return mapperFactory.getMapperFacade();
    }
    //endregion

    //region Utility methods
    private void initEmailMappings(final MapperFactory mapperFactory) {
        mapperFactory.classMap(EmailModel.class, Email.class).byDefault().register();
        mapperFactory.classMap(EmailWithAttachmentsModel.class, Email.class)
                .field("attachments{uuid}", "attachments{}")
                .byDefault().register();
        mapperFactory.classMap(CreateEmailDto.class, EmailModel.class).byDefault().register();
    }

    private void initEmailSendingStateMappings(final MapperFactory mapperFactory) {
        mapperFactory.getConverterFactory().registerConverter(new AbstractEmailSendingStateModelToAbstractEmailSendingStateConverter());

        mapperFactory.classMap(BounceEmailSendingStateModel.class, BounceEmailSendingState.class).byDefault().register();
        mapperFactory.classMap(BounceTypeModel.class, BounceType.class).byDefault().register();
        mapperFactory.classMap(ClickEmailSendingStateModel.class, ClickEmailSendingState.class).byDefault().register();
        mapperFactory.classMap(DeferredEmailSendingStateModel.class, DeferredEmailSendingState.class).byDefault().register();
        mapperFactory.classMap(DeliveredEmailSendingStateModel.class, DeliveredEmailSendingState.class).byDefault().register();
        mapperFactory.classMap(DroppedEmailSendingStateModel.class, DroppedEmailSendingState.class).byDefault().register();
        mapperFactory.classMap(EmailSendingEventTypeModel.class, EmailSendingEventType.class).byDefault().register();
        mapperFactory.classMap(EmailSendingNewsletterModel.class, EmailSendingNewsletter.class).byDefault().register();
        mapperFactory.classMap(GroupResubscribeEmailSendingStateModel.class, GroupResubscribeEmailSendingState.class).byDefault().register();
        mapperFactory.classMap(GroupUnsubscribeEmailSendingStateModel.class, GroupUnsubscribeEmailSendingState.class).byDefault().register();
        mapperFactory.classMap(OpenEmailSendingStateModel.class, OpenEmailSendingState.class).byDefault().register();
        mapperFactory.classMap(ProcessedEmailSendingStateModel.class, ProcessedEmailSendingState.class).byDefault().register();
        mapperFactory.classMap(SpamReportEmailSendingStateModel.class, SpamReportEmailSendingState.class).byDefault().register();
        mapperFactory.classMap(UnsubscribeEmailSendingStateModel.class, UnsubscribeEmailSendingStateModel.class).byDefault().register();
        mapperFactory.classMap(EmailOriginModel.class, EmailOrigin.class).byDefault().register();
    }
    //endregion
}
