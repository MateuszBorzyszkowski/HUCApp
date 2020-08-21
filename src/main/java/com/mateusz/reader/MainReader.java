package com.mateusz.reader;

import com.mateusz.enums.VendorOption;
import com.mateusz.reader.validator.MainReaderValidator;

import java.util.*;

public class MainReader {
    private static MainReader instance = null;
    private final MainReaderValidator mainReaderValidator = MainReaderValidator.getInstance();
    private final VendorReader vendorReader = VendorReader.getInstance();

    private MainReader() {
    }

    public static MainReader getInstance() {
        if (instance == null) {
            instance = new MainReader();
        }
        return instance;
    }

    public boolean readCommand(String command) {
        String[] splitCommand = command.split("\\s");

        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

        if (mainReaderValidator.validate(parseCommand.size())) {
            switch (parseCommand.get(0)) {
                case "add":
                    return addCommand(parseCommand);
                case "remove":
                    return removeCommand(parseCommand);
                case "show":
                    return showCommand(parseCommand);
                case "help":
                    System.out.println("Help");
                    return true;
                case "exit":
                    System.out.println("Exit");
                    return false;
                default:
                    System.out.println("Command '" + parseCommand.get(0) + "' not recognized. Type 'help' command to more information.");
                    return true;
            }
        }
        System.out.println("Number of commands is not enough! Type 'help' command to more information.");
        return true;
    }

    private boolean addCommand(ArrayList<String> command) {
        command.remove(0);

        switch (command.get(0)) {
            case "vendor":
                return vendorReader.initVendorCommand(command, VendorOption.ADD);
            case "place":
            default:
                System.out.println("Command '" + command.get(0) + "' for 'add' option not recognized! Type 'help' command to more information.");
                return true;
        }

    }

    private boolean removeCommand(ArrayList<String> command) {
        command.remove(0);

        switch (command.get(0)) {
            case "vendor":
                return vendorReader.initVendorCommand(command, VendorOption.REMOVE);
            case "place":
            default:
                System.out.println("Command '" + command.get(0) + "' for 'remove' option not recognized! Type 'help' command to more information.");
                return true;
        }

    }

    private boolean showCommand(ArrayList<String> command) {
        command.remove(0);

        switch (command.get(0)) {
            case "vendor":
                return vendorReader.initVendorCommand(command, VendorOption.SHOW);
            case "place":
            default:
                System.out.println("Command '" + command.get(0) + "' for 'show' option not recognized! Type 'help' command to more information.");
                return true;
        }

    }
}
