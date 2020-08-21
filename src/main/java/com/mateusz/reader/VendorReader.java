package com.mateusz.reader;

import com.mateusz.api.VendorService;
import com.mateusz.enums.VendorOption;
import com.mateusz.model.Vendor;
import com.mateusz.reader.validator.VendorReaderValidator;
import com.mateusz.service.VendorServiceImpl;

import java.util.ArrayList;
import java.util.Iterator;

public class VendorReader {
    private static VendorReader instance = null;
    private final VendorService vendorService = VendorServiceImpl.getInstance();
    private final VendorReaderValidator vendorReaderValidator = VendorReaderValidator.getInstance();

    private VendorReader() {
    }

    public static VendorReader getInstance() {
        if (instance == null) {
            instance = new VendorReader();
        }
        return instance;
    }

    public boolean initVendorCommand(ArrayList<String> command, VendorOption option) {
        return vendorCommand(command, option);
    }

    private boolean vendorCommand(ArrayList<String> command, VendorOption option) {
        String name = null;
        String utility = null;
        String s = null;

        command.remove(0);
        Iterator<String> iter = command.iterator();

        while (iter.hasNext()) {
            s = iter.next();
            switch (s) {
                case "-name":
                case "-n":
                    name = iter.next();
                    break;
                case "-utility":
                case "-u":
                    utility = iter.next();
                    break;
                default:
                    System.out.println("Parameter '" + s + "' not recognized! Type 'help' command to more information.");
                    return true;
            }

        }
        runVendorOption(name, utility, option);
        return true;
    }

    private void runVendorOption(String name, String utility, VendorOption option) {
        if (vendorReaderValidator.isSomeNameExist(name, utility, option)) {
            switch (option) {
                case ADD:
                    vendorService.addVendor(new Vendor(name, utility));
                    break;
                case REMOVE:
                    vendorService.removeVendorByName(name);
                    break;
                case SHOW:
                    for (Vendor vendor : vendorService.getAllVendors()) {
                        System.out.println(vendor.getName() + " (" + vendor.getUtility() + ")");
                    }
                    break;
            }
        } else {
            System.out.println("Invalid count of parameters!");
        }
    }
}
