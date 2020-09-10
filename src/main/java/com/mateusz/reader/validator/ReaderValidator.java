package com.mateusz.reader.validator;

import com.mateusz.enums.ReaderOption;

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

    public boolean readerValidate(int count, String command){
        return isExitOrHelpOption(command) || count > 1;
    }

    public boolean readerValidate(int count, ReaderOption option, String parameter) {
        if (parameter.equals("vendor")){
            return vendorValidate(count, option);
        } else if (parameter.equals("place")) {
            return placeValidate(count, option);
        } else if (parameter.equals("settlement")) {
            return settlementValidate(count, option);
        }
        return false;
    }

    private boolean vendorValidate(int count, ReaderOption option){
        if (option == ReaderOption.ADD) {
            return count == 5;
        } else if (option == ReaderOption.REMOVE) {
            return count == 3;
        } else if (option == ReaderOption.SHOW) {
            return count == 1;
        }
        return false;
    }

    private boolean placeValidate(int count, ReaderOption option){
        if (option == ReaderOption.ADD) {
            return count == 10;
        } else if (option == ReaderOption.REMOVE) {
            return count == 3;
        } else if (option == ReaderOption.SHOW) {
            return count == 1;
        }
        return false;
    }

    private boolean settlementValidate(int count, ReaderOption option){
        if (option == ReaderOption.ADD) {
            return count == 9;
        } else if (option == ReaderOption.REMOVE) {
            return count == 2;
        } else if (option == ReaderOption.SHOW) {
            return count == 1;
        }
        return false;
    }

    private boolean isExitOrHelpOption (String command) {
        return command.equals("help");
    }
}
