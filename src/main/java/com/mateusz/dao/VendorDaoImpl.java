package com.mateusz.dao;

import com.mateusz.api.VendorDao;
import com.mateusz.model.Vendor;
import com.mateusz.utils.SqlClientDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class VendorDaoImpl implements VendorDao {
    private final static VendorDao instance = new VendorDaoImpl();
    private final Connection connection;

    private VendorDaoImpl() {
        this.connection = SqlClientDB.getConnection();
    }
    public static VendorDao getInstance() {
        return VendorDaoImpl.instance;
    }

    @Override
    public void addVendor(Vendor vendor) {
        PreparedStatement statement;

        try {
            String query = "insert into vendor (vendor_name, service) values (?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, vendor.getName());
            statement.setString(2, vendor.getService());
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeVendorByName(String vendorName) {
        PreparedStatement statement;

        try {
            String query = "delete from vendor where vendor_name = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, vendorName);
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = new LinkedList<Vendor>();
        Statement statement = null;

        try {
            statement = connection.createStatement();
            String query = "select * from vendor";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String vendorName = resultSet.getString("vendor_name");
                String service = resultSet.getString("service");

                Vendor vendor = new Vendor(vendorName, service);
                vendors.add(vendor);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return vendors;
    }
}
