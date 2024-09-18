package com.demo.smartjob.exception;

import com.demo.smartjob.enums.ErrorCodeEnum;

/**
 * A service exception
 *
 * @author Alberto Niño
 */
public class EmailException extends ServiceException {

    /**
     * Constructs the service exception.
     *
     * @param error  A predefined error
     * @param params Message parameters (if any)
     */
    public EmailException(final ErrorCodeEnum error, final String... params) {
        super(error, params);
    }

}
