package com.mateusz;

import com.mateusz.api.VendorService;
import com.mateusz.model.Vendor;
import com.mateusz.service.VendorServiceImpl;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        VendorService vendorService = VendorServiceImpl.getInstance();
        Scanner scanner = new Scanner(System.in);
        boolean appOn = true;
        int option;
        System.out.println("HUGApp");

        while (appOn) {
            System.out.println("1. Add vendor");
            System.out.println("2. Remove vendor");
            System.out.println("3. Show vendors");
            System.out.println("0. Exit");

            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Type name of vendor: ");
                    String vendorName = scanner.next();
                    System.out.print("Type kind of vendor: ");
                    String utility = scanner.next();
                    Vendor vendor = new Vendor(vendorName, utility);
                    vendorService.addVendor(vendor);
                    break;
                case 2:
                    System.out.print("Type name of vendor: ");
                    String deleteVendorName = scanner.next();
                    vendorService.removeVendorByName(deleteVendorName);
                    break;
                case 3:
                    for (Vendor vendor1 : vendorService.getAllVendors()) {
                        System.out.println(vendor1.getName());
                    }
                    break;
                case 0:
                    appOn = false;
                    break;
            }
        }
    }
}
