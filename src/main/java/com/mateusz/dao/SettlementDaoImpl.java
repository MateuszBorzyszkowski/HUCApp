package com.mateusz.dao;

import com.mateusz.api.SettlementDao;
import com.mateusz.exception.CannotFindVendorOrPlaceInDatabaseException;
import com.mateusz.model.Settlement;
import com.mateusz.utils.SqlClientDB;

import java.sql.*;
import java.util.List;

public class SettlementDaoImpl implements SettlementDao {
    private final static SettlementDao instance = new SettlementDaoImpl();
    private final Connection connection;

    private SettlementDaoImpl() {
        this.connection = SqlClientDB.getConnection();
    }

    public static SettlementDao getInstance() {
        return SettlementDaoImpl.instance;
    }

    @Override
    public void addSettlement(Settlement settlement) {
        PreparedStatement statement;

        try {
            String query = "insert into settlement (meter_status, date, vendor_id, place_id) values (?,?,?,?)";
            statement = connection.prepareStatement(query);
            statement.setString(1, settlement.getMeterStatus());
            statement.setString(2, settlement.getMeasurementDate());
            statement.setInt(3, getIdByName(settlement.getVendorName(), "vendor", "vendor_name"));
            statement.setInt(4, getIdByName(settlement.getPlaceName(), "place", "place_name"));
            statement.execute();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private int getIdByName(String name, String table, String column) {
        PreparedStatement statement;
        int id = 0;

        try {
            String query = "select id from " + table + " where " + column + " = ?";
            statement = connection.prepareStatement(query);
            statement.setString(1, name);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("id");
            }

            if (id == 0) {
                throw new CannotFindVendorOrPlaceInDatabaseException("Cannot find Vendor/Place in database!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (CannotFindVendorOrPlaceInDatabaseException e) {
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<Settlement> getAllSettlements() {
        return null;
    }
}
