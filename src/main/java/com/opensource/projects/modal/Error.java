package com.opensource.projects.modal;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public enum Error {
    USER_ALREADY_EXISTS("USER_ALREADY_EXISTS"),
    USER_NOT_FOUND("USER_NOT_FOUND"),
    INCORRECT_EMAIL_AND_PASSWORD("INCORRECT_EMAIL_AND_PASSWORD"),
    PROJECT_NOT_FOUND("PROJECT_NOT_FOUND"),
    INVALID_PARAMETERS("INVALID_PARAMETERS");

    @Getter
    public final String getError;
}
