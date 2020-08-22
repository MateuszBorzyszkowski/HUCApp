package com.mateusz.exception;

public class CommandNotRecognizedException extends Exception {
    public CommandNotRecognizedException() {}
    public CommandNotRecognizedException(String message) {super(message);}
}
