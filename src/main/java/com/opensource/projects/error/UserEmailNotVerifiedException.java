package com.opensource.projects.error;

public class UserEmailNotVerifiedException  extends Exception{
    public UserEmailNotVerifiedException() {
        super();
    }

    public UserEmailNotVerifiedException(String message) {
        super(message);
    }

    public UserEmailNotVerifiedException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserEmailNotVerifiedException(Throwable cause) {
        super(cause);
    }

    protected UserEmailNotVerifiedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
