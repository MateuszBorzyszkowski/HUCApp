package com.mateusz.service;

import com.mateusz.api.VendorDao;
import com.mateusz.api.VendorService;
import com.mateusz.dao.VendorDaoImpl;
import com.mateusz.exception.VendorToRemoveNotExistException;
import com.mateusz.model.Vendor;

import java.util.List;

public class VendorServiceImpl implements VendorService {
    private static VendorServiceImpl instance = null;
    private VendorDao vendorDao = VendorDaoImpl.getInstance();

    private VendorServiceImpl() {}
    public static VendorServiceImpl getInstance() {
        if (instance == null) {
            instance = new VendorServiceImpl();
        }
        return instance;
    }

    @Override
    public boolean addVendor(Vendor vendor) {
        //if (isVendorAlreadyExist(vendor.getName())) {
            // TODO: exception
        //}
        vendorDao.addVendor(vendor);
        return true;
    }

    @Override
    public void removeVendorByName(String vendorName) throws VendorToRemoveNotExistException {
        if (isVendorAlreadyExist(vendorName)) {
            vendorDao.removeVendorByName(vendorName);
        } else {
            throw new VendorToRemoveNotExistException("No vendor in the database!");
        }
    }

    @Override
    public Vendor getVendorByName(String vendorName) {
        List<Vendor> vendors = getAllVendors();

        for (Vendor vendor : vendors) {
            if (vendor.getName().equals(vendorName)) {
                return vendor;
            }
        }
        return null;
    }

    @Override
    public List<Vendor> getAllVendors() {
        return vendorDao.getAllVendors();
    }

    private boolean isVendorAlreadyExist(String vendorName) {
        Vendor vendor = getVendorByName(vendorName);

        return vendor != null;
    }
}
