package com.mateusz.reader;

import com.mateusz.api.VendorService;
import com.mateusz.enums.VendorOption;
import com.mateusz.model.Vendor;
import com.mateusz.service.VendorServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Reader {
    private static Reader instance = null;
    private VendorService vendorService = VendorServiceImpl.getInstance();

    private Reader() {
    }

    public static Reader getInstance() {
        if (instance == null) {
            instance = new Reader();
        }
        return instance;
    }

    public boolean readCommand(String command) {
        String[] splitCommand = command.split("\\s");

        ArrayList<String> parseCommand = new ArrayList<String>(Arrays.asList(splitCommand));

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
                System.out.println("Command not recognized. Type 'help' command to more information.");
                return true;
        }
    }

    private boolean addCommand(ArrayList<String> command) {
        command.remove(0);

        switch (command.get(0)) {
            case "vendor":
                return vendorCommand(command, VendorOption.ADD);
            case "place":
            default:
                System.out.println("Command for '" + command.get(0) + "' option not recognized. Type 'help' command to more information.");
                return true;
        }

    }

    private boolean removeCommand(ArrayList<String> command) {
        command.remove(0);

        switch (command.get(0)) {
            case "vendor":
                return vendorCommand(command, VendorOption.REMOVE);
            case "place":
            default:
                System.out.println("Command for '" + command.get(0) + "' option not recognized. Type 'help' command to more information.");
                return true;
        }

    }

    private boolean showCommand(ArrayList<String> command) {
        command.remove(0);

        switch (command.get(0)) {
            case "vendor":
                return vendorCommand(command, VendorOption.SHOW);
            case "place":
            default:
                System.out.println("Command for '" + command.get(0) + "' option not recognized. Type 'help' command to more information.");
                return true;
        }

    }

    private boolean vendorCommand(ArrayList<String> command, VendorOption option) {
        String name = null;
        String utility = null;

        command.remove(0);

        switch (command.get(0)) {
            case "-n":
            case "-name":
                command.remove(0);
                name = command.get(0);
                command.remove(0);
            case "-u":
            case "-utility":
                command.remove(0);
                utility = command.get(0);
                command.remove(0);
            default:
                if (!command.isEmpty()) {
                    System.out.println("Parameter '" + command.get(0) + "' not recognized. Type 'help' command to more information.");
                } else {
                    runOption(name, utility, option);
                    //System.out.println(name + "," + utility);

                }
        }
        return true;
    }

    private void runOption(String name, String utility, VendorOption option) {
        switch (option) {
            case ADD:
                vendorService.addVendor(new Vendor(name, utility));
            case REMOVE:
                vendorService.removeVendorByName(name);
            case SHOW:
                vendorService.getAllVendors();
        }
    }
}
