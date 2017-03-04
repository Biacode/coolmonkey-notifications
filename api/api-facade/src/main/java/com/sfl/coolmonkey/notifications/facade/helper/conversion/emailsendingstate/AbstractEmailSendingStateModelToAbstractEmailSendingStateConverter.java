package com.sfl.coolmonkey.notifications.facade.helper.conversion.emailsendingstate;

import com.sfl.coolmonkey.notifications.api.model.email.aggregation.*;
import com.sfl.coolmonkey.notifications.facade.common.exception.FacadeRuntimeException;
import com.sfl.coolmonkey.notifications.service.email.model.aggregation.*;
import ma.glasnost.orika.converter.BidirectionalConverter;
import ma.glasnost.orika.metadata.Type;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 2/2/16
 * Time: 6:25 PM
 */
@SuppressWarnings({
        "checkstyle:com.puppycrawl.tools.checkstyle.checks.metrics.CyclomaticComplexityCheck",
        "squid:MethodCyclomaticComplexity"
})
public class AbstractEmailSendingStateModelToAbstractEmailSendingStateConverter extends BidirectionalConverter<AbstractEmailSendingStateModel, AbstractEmailSendingState> {
    //region Conversion methods
    @Override
    public AbstractEmailSendingState convertTo(final AbstractEmailSendingStateModel model, final Type<AbstractEmailSendingState> type) {
        switch (model.getEvent()) {
            case BOUNCE:
                return mapperFacade.map(model, BounceEmailSendingState.class);
            case CLICK:
                return mapperFacade.map(model, ClickEmailSendingState.class);
            case DEFERRED:
                return mapperFacade.map(model, DeferredEmailSendingState.class);
            case DELIVERED:
                return mapperFacade.map(model, DeliveredEmailSendingState.class);
            case DROPPED:
                return mapperFacade.map(model, DroppedEmailSendingState.class);
            case OPEN:
                return mapperFacade.map(model, OpenEmailSendingState.class);
            case PROCESSED:
                return mapperFacade.map(model, ProcessedEmailSendingState.class);
            case SPAM_REPORT:
                return mapperFacade.map(model, SpamReportEmailSendingState.class);
            case UNSUBSCRIBE:
                return mapperFacade.map(model, UnsubscribeEmailSendingState.class);
            case GROUP_UNSUBSCRIBE:
                return mapperFacade.map(model, GroupUnsubscribeEmailSendingState.class);
            case GROUP_RESUBSCRIBE:
                return mapperFacade.map(model, GroupResubscribeEmailSendingState.class);
            default:
                throw new FacadeRuntimeException("Can not find conversions for provided email sending event type");
        }
    }

    @Override
    public AbstractEmailSendingStateModel convertFrom(final AbstractEmailSendingState emailSendingState, final Type<AbstractEmailSendingStateModel> type) {
        switch (emailSendingState.getEvent()) {
            case BOUNCE:
                return mapperFacade.map(emailSendingState, BounceEmailSendingStateModel.class);
            case CLICK:
                return mapperFacade.map(emailSendingState, ClickEmailSendingStateModel.class);
            case DEFERRED:
                return mapperFacade.map(emailSendingState, DeferredEmailSendingStateModel.class);
            case DELIVERED:
                return mapperFacade.map(emailSendingState, DeliveredEmailSendingStateModel.class);
            case DROPPED:
                return mapperFacade.map(emailSendingState, DroppedEmailSendingStateModel.class);
            case OPEN:
                return mapperFacade.map(emailSendingState, OpenEmailSendingStateModel.class);
            case PROCESSED:
                return mapperFacade.map(emailSendingState, ProcessedEmailSendingStateModel.class);
            case SPAM_REPORT:
                return mapperFacade.map(emailSendingState, SpamReportEmailSendingStateModel.class);
            case UNSUBSCRIBE:
                return mapperFacade.map(emailSendingState, UnsubscribeEmailSendingStateModel.class);
            case GROUP_UNSUBSCRIBE:
                return mapperFacade.map(emailSendingState, GroupUnsubscribeEmailSendingStateModel.class);
            case GROUP_RESUBSCRIBE:
                return mapperFacade.map(emailSendingState, GroupResubscribeEmailSendingStateModel.class);
            default:
                throw new FacadeRuntimeException("Can not find conversions for provided email sending event type");
        }
    }
    //endregion
}
