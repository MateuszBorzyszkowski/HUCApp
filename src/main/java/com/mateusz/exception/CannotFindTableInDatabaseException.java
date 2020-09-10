package com.mateusz.exception;

import java.io.IOError;
import java.io.IOException;

public class CannotFindTableInDatabaseException extends IOException {
    public CannotFindTableInDatabaseException() {}
    public CannotFindTableInDatabaseException(String message) {super(message);}
}
