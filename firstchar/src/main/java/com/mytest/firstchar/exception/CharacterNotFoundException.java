package com.mytest.firstchar.exception;

public class CharacterNotFoundException extends RuntimeException {
    public CharacterNotFoundException(final String messagge) {
        super(messagge);
    }
}
