package com.sfl.coolmonkey.notifications.queue.producer.common.exception;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 11:25
 */
public class ProducerQueueRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 69396281084808715L;

    //region Constructors
    public ProducerQueueRuntimeException() {
        super();
    }

    public ProducerQueueRuntimeException(final String message) {
        super(message);
    }

    public ProducerQueueRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ProducerQueueRuntimeException(final Throwable cause) {
        super(cause);
    }
    //endregion
}
