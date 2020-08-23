package com.mateusz.reader;

import com.mateusz.enums.VendorOption;
import com.mateusz.exception.CommandNotRecognizedException;
import com.mateusz.exception.CountOfCommandsNotEnoughException;
import com.mateusz.exception.VendorAlreadyExistException;
import com.mateusz.exception.VendorToRemoveNotExistException;
import com.mateusz.reader.validator.ReaderValidator;

import java.util.*;

public class MainReader {
    private static MainReader instance = null;
    private final ReaderValidator readerValidator = ReaderValidator.getInstance();
    private final VendorReader vendorReader = VendorReader.getInstance();

    private MainReader() {
    }

    public static MainReader getInstance() {
        if (instance == null) {
            instance = new MainReader();
        }
        return instance;
    }

    public boolean initMainCommand(String command) {
        String[] splitCommand = command.split("\\s");
        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        if (parseCommand.get(0).equals("exit")) {
            return false;
        } else {
            readCommand(parseCommand);
            return true;
        }
    }


    public boolean readCommand(ArrayList<String> command) {

        try {
            if (readerValidator.mainReaderValidate(command.size(), command.get(0))) {
                switch (command.get(0)) {
                    case "add":
                        return addCommand(command);
                    case "remove":
                        return removeCommand(command);
                    case "show":
                        return showCommand(command);
                    case "help":
                        System.out.println("Help");
                    default:
                        throw new CommandNotRecognizedException("Command '" + command.get(0) + "' not recognized. Type 'help' command to more information.");
                }
            } else {
                throw new CountOfCommandsNotEnoughException("Number of commands is not enough! Type 'help' command to more information.");
            }
        } catch (CommandNotRecognizedException e) {
            e.printStackTrace();
        } catch (CountOfCommandsNotEnoughException e) {
            e.printStackTrace();
        } catch (VendorToRemoveNotExistException e) {
            e.printStackTrace();
        } catch (VendorAlreadyExistException e) {
            e.printStackTrace();
        }
        return false;
    }

    private boolean addCommand(ArrayList<String> command) throws CommandNotRecognizedException, CountOfCommandsNotEnoughException, VendorToRemoveNotExistException, VendorAlreadyExistException {
        command.remove(0);

        if (readerValidator.mainReaderValidate(command.size(), VendorOption.ADD)) {
            switch (command.get(0)) {
                case "vendor":
                    return vendorReader.initVendorCommand(command, VendorOption.ADD);
                case "place":
                default:
                    throw new CommandNotRecognizedException("Command '" + command.get(0) + "' for 'add' option not recognized! Type 'help' command to more information.");
            }
        } else {
            throw new CountOfCommandsNotEnoughException("Number of commands is not enough! Type 'help' command to more information.");
        }

    }

    private boolean removeCommand(ArrayList<String> command) throws CommandNotRecognizedException, CountOfCommandsNotEnoughException, VendorToRemoveNotExistException, VendorAlreadyExistException {
        command.remove(0);

        if (readerValidator.mainReaderValidate(command.size(), VendorOption.REMOVE)) {
            switch (command.get(0)) {
                case "vendor":
                    return vendorReader.initVendorCommand(command, VendorOption.REMOVE);
                case "place":
                default:
                    throw new CommandNotRecognizedException("Command '" + command.get(0) + "' for 'remove' option not recognized! Type 'help' command to more information.");
            }
        } else {
            throw new CountOfCommandsNotEnoughException("Number of commands is not enough! Type 'help' command to more information.");
        }

    }

    private boolean showCommand(ArrayList<String> command) throws CommandNotRecognizedException, CountOfCommandsNotEnoughException, VendorToRemoveNotExistException, VendorAlreadyExistException {
        command.remove(0);

        if (readerValidator.mainReaderValidate(command.size(), VendorOption.SHOW)) {
            switch (command.get(0)) {
                case "vendor":
                    return vendorReader.initVendorCommand(command, VendorOption.SHOW);
                case "place":
                default:
                    throw new CommandNotRecognizedException("Command '" + command.get(0) + "' for 'show' option not recognized! Type 'help' command to more information.");
            }
        } else {
            throw new CountOfCommandsNotEnoughException("Number of commands is not enough! Type 'help' command to more information.");
        }
    }
}
