package com.sfl.coolmonkey.notifications.facade.common.exception;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 8/5/15
 * Time: 5:42 PM
 */
public class FacadeRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 8093599021317031289L;

    //region Constructors
    public FacadeRuntimeException(final Throwable cause) {
        super(cause);
    }

    public FacadeRuntimeException(final String message) {
        super(message);
    }

    public FacadeRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }
    //endregion
}
