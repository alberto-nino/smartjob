package com.demo.smartjob.exception;

import com.demo.smartjob.enums.ErrorCodeEnum;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * A service exception.
 *
 * @author Alberto Niño
 */
@Getter
public class ServiceException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected final HttpStatus httpStatus;
    protected final int code;

    /**
     * Constructs the service exception.
     *
     * @param error  A predefined error
     * @param params Message parameters (if any)
     */
    public ServiceException(final ErrorCodeEnum error, final String... params) {
        this(error, null, params);
    }

    /**
     * Constructs the service exception.
     *
     * @param error  A predefined error
     * @param params Message parameters (if any)
     */
    public ServiceException(final ErrorCodeEnum error, final String message, final Throwable cause) {
        super(message, cause);
        this.httpStatus = error.getHttpStatus();
        this.code = error.getCode();
    }

    /**
     * Constructs the service exception.
     *
     * @param error  A predefined error
     * @param cause  An error cause (will be used only in logs)
     * @param params Message parameters
     */
    public ServiceException(final ErrorCodeEnum error, final Throwable cause, final String... params) {
        super(String.format(error.getMessage(), (Object[]) params), cause);
        this.httpStatus = error.getHttpStatus();
        this.code = error.getCode();
    }

    /**
     * Constructs the service exception.
     *
     * @param code  A predefined code
     * @param message A predefined message
     */
    public ServiceException(final int code, final String message, final HttpStatus status) {
        super(message, null);
        this.httpStatus = status;
        this.code = code;
    }

}
