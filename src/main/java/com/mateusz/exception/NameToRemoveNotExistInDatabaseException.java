package com.mateusz.exception;

public class NameToRemoveNotExistInDatabaseException extends Exception {
    public NameToRemoveNotExistInDatabaseException() {}
    public NameToRemoveNotExistInDatabaseException(String message) {super(message);}
}
