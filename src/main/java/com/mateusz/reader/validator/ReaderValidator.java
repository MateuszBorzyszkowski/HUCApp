package com.mateusz.reader.validator;

import com.mateusz.enums.ReaderOption;
import com.mateusz.exception.CommandNotRecognizedException;
import com.mateusz.exception.CountOfCommandsIsInvalidException;

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

    public boolean readerValidate(int count, ReaderOption option, String parameter) {
        boolean status = false;
        try {
            switch (parameter) {
                case "vendor":
                    status = vendorValidate(count, option);
                    break;
                case "place":
                    status = placeValidate(count, option);
                    break;
                case "settlement":
                    status = settlementValidate(count, option);
                    break;
                default:
                    throw new CommandNotRecognizedException("Command '" + parameter + "' for option not recognized! Type 'help' command to more information.");
            }
            if (!status) {
                throw new CountOfCommandsIsInvalidException("Number of commands is invalid! Type 'help' command to more information.");
            }
        } catch (CommandNotRecognizedException e) {
            e.printStackTrace();
        } catch (CountOfCommandsIsInvalidException e) {
            e.printStackTrace();
        }
        return status;
    }

    private boolean vendorValidate(int count, ReaderOption option) {
        boolean status = false;
        switch (option) {
            case ADD:
                status = count == 5;
            case REMOVE:
                status = count == 3;
            case SHOW:
                status = count == 1;
        }
        return status;
    }

    private boolean placeValidate(int count, ReaderOption option){
        boolean status = false;
        switch (option) {
            case ADD:
                status = count == 10;
            case REMOVE:
                status = count == 3;
            case SHOW:
                status = count == 1;
        }
        return status;
    }

    private boolean settlementValidate(int count, ReaderOption option){
        boolean status = false;
        switch (option) {
            case ADD:
                status = count == 9;
            case REMOVE:
                status = count == 3;
            case SHOW:
                status = count == 1;
        }
        return status;
    }
}
