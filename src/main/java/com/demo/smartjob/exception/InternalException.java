package com.demo.smartjob.exception;

public class InternalException extends RuntimeException {

    public InternalException(final String desc, final Throwable e) {
        super(desc, e);
    }

    public InternalException(final String string) {
        super(string);
    }
}
