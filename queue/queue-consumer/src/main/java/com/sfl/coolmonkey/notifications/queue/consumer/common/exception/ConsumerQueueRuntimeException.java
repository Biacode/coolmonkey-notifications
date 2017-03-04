package com.sfl.coolmonkey.notifications.queue.consumer.common.exception;

/**
 * User: Arthur Asatryan
 * Company: SFL LLC
 * Date: 08/04/16
 * Time: 11:00
 */
public class ConsumerQueueRuntimeException extends RuntimeException {
    private static final long serialVersionUID = 2633713011245697278L;

    //region Constructors
    public ConsumerQueueRuntimeException() {
    }

    public ConsumerQueueRuntimeException(final String message) {
        super(message);
    }

    public ConsumerQueueRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ConsumerQueueRuntimeException(final Throwable cause) {
        super(cause);
    }
    //endregion
}
