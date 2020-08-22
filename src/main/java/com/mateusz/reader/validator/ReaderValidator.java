package com.mateusz.reader.validator;

import com.mateusz.enums.VendorOption;

public class ReaderValidator {
    private static ReaderValidator instance = null;

    private ReaderValidator() {
    }

    public static ReaderValidator getInstance() {
        if (instance == null) {
            instance = new ReaderValidator();
        }
        return instance;
    }

    public boolean mainReaderValidate(int count, String command){
        return isExitOrHelpOption(command) || count > 1;
    }

    public boolean mainReaderValidate(int count, VendorOption option) {
        if (option == VendorOption.ADD) {
            return count == 5;
        } else if (option == VendorOption.REMOVE) {
            return count == 3;
        } else if (option == VendorOption.SHOW) {
            return count == 1;
        }
        return false;
    }

    private boolean isExitOrHelpOption (String command) {
        return command.equals("help") || command.equals("exit");
    }
}
