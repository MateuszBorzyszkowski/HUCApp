package com.mateusz.api;

import com.mateusz.exception.VendorAlreadyExistException;
import com.mateusz.exception.VendorToRemoveNotExistException;
import com.mateusz.model.Vendor;

import java.util.List;

public interface VendorService {
    boolean addVendor(Vendor vendor) throws VendorAlreadyExistException;
    void removeVendorByName(String vendorName) throws VendorToRemoveNotExistException;
    Vendor getVendorByName(String vendorName);
    List<Vendor> getAllVendors();
}
