package com.mateusz.reader.validator;

import com.mateusz.enums.VendorOption;

import java.util.Iterator;

public class VendorReaderValidator {
    private static VendorReaderValidator instance = null;

    private VendorReaderValidator() {
    }

    public static VendorReaderValidator getInstance() {
        if (instance == null) {
            instance = new VendorReaderValidator();
        }
        return instance;
    }

    public boolean isSomeNameExist(String name, String utility, VendorOption option) {
        switch (option) {
            case ADD:
                return nameExist(name) && utilityExist(utility);
            case REMOVE:
                return nameExist(name);
            case SHOW:
                return true;
        }
        return false;
    }

    private boolean nameExist(String name) {
        return name != null;
    }

    private boolean utilityExist(String utility) {
        return utility != null;
    }

}
