package com.mateusz.api;

import com.mateusz.exception.NameInDatabaseAlreadyExistException;
import com.mateusz.exception.NameToRemoveNotExistInDatabaseException;
import com.mateusz.model.Vendor;

import java.util.List;

public interface VendorService {
    void addVendor(Vendor vendor) throws NameInDatabaseAlreadyExistException;
    void removeVendorByName(String vendorName) throws NameToRemoveNotExistInDatabaseException;
    List<Vendor> getAllVendors();
}
