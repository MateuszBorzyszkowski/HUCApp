package com.mateusz.api;

import com.mateusz.model.Vendor;

import java.util.List;

public interface VendorDao {
    void addVendor(Vendor vendor);
    void removeVendorByName(String vendorName);
    List<Vendor> getAllVendors();
}
