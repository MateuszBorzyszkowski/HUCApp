package com.mateusz.exception;

public class NameInDatabaseAlreadyExistException extends Exception {
    public NameInDatabaseAlreadyExistException() {}
    public NameInDatabaseAlreadyExistException(String message) {super(message);}
}
