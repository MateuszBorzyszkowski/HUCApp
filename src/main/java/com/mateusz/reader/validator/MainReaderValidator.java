package com.mateusz.reader.validator;

public class MainReaderValidator {
    private static MainReaderValidator instance = null;

    private MainReaderValidator() {
    }

    public static MainReaderValidator getInstance() {
        if (instance == null) {
            instance = new MainReaderValidator();
        }
        return instance;
    }

    public boolean validate(int count){
        return count > 1;
    }
}
