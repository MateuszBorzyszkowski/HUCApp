package com.mateusz.exception;

import java.io.IOError;
import java.io.IOException;

public class CannotFindVendorOrPlaceInDatabaseException extends IOException {
    public CannotFindVendorOrPlaceInDatabaseException() {}
    public CannotFindVendorOrPlaceInDatabaseException(String message) {super(message);}
}
