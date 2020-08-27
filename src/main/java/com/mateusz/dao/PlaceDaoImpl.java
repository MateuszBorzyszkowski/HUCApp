package com.mateusz.dao;

import com.mateusz.api.PlaceDao;
import com.mateusz.api.VendorDao;
import com.mateusz.model.Place;
import com.mateusz.utils.SqlClientDB;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class PlaceDaoImpl implements PlaceDao {
    private final static PlaceDao instance = new PlaceDaoImpl();
    private final Connection connection;

    private PlaceDaoImpl() {
        this.connection = SqlClientDB.getConnection();
    }
    public static PlaceDao getInstance() {
        return PlaceDaoImpl.instance;
    }

    @Override
    public void addPlace(Place place) {
        PreparedStatement statement;
        int addr_id = 0;

        try {
            String addressQuery = "insert into address (street, home_number, apartment_number, postal_code, city) values (?,?,?,?,?)";
            statement = connection.prepareStatement(addressQuery);
            statement.setString(1, place.getStreet());
            statement.setString(2, place.getHomeNumber());
            statement.setString(3, place.getApartmentNumber());
            statement.setString(4, place.getPostalCode());
            statement.setString(5, place.getCity());
            statement.execute();

            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                addr_id = resultSet.getInt(1);
            }
            if (addr_id == 0) {
                throw new SQLException("Creating place in database failed.");
            } else {
                String placeQuery = "insert into place (place_name, address_id) values (?,?)";
                statement = connection.prepareStatement(placeQuery);
                statement.setString(1, place.getName());
                statement.setInt(2, addr_id);
                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removePlaceByName(String placeName) {
        PreparedStatement statement;
        int addr_id = 0;

        try {
            String selectQuery = "select address_id from place where place_name = ?";
            statement = connection.prepareStatement(selectQuery);
            statement.setString(1, placeName);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                addr_id = resultSet.getInt("address_id");
            }

            if (addr_id == 0) {
                throw new SQLException("Deleting place in database failed.");
            } else {
                String addressPlace = "delete from address where id = ?";
                statement = connection.prepareStatement(addressPlace);
                statement.setInt(1, addr_id);
                statement.execute();

                String placeQuery = "delete from place where place_name = ?";
                statement = connection.prepareStatement(placeQuery);
                statement.setString(1, placeName);
                statement.execute();
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Place> getAllPlaces() {
        List<Place> places = new LinkedList<Place>();
        PreparedStatement preparedStatement = null;
        Statement statement = null;
        int addr_id = 0;

        try {
            statement = connection.createStatement();
            String placeQuery = "select * from place";
            ResultSet resultSet = statement.executeQuery(placeQuery);

            while (resultSet.next()) {
                String placeName = resultSet.getString("place_name");
                addr_id = resultSet.getInt("address_id");

                if (addr_id == 0) {
                    throw new SQLException("Searching places in database failed..");
                } else {
                    String addressPlace = "select * from address where id = ?";
                    preparedStatement = connection.prepareStatement(addressPlace);
                    preparedStatement.setInt(1, addr_id);

                    ResultSet addressResultSet = preparedStatement.executeQuery();

                    if (addressResultSet.next()) {
                        String street = addressResultSet.getString("street");
                        String homeNumber = addressResultSet.getString("home_number");
                        String apartmentNumber = addressResultSet.getString("apartment_number");
                        String code = addressResultSet.getString("postal_code");
                        String city = addressResultSet.getString("city");

                        Place place = new Place(placeName, street, homeNumber, apartmentNumber, code, city);
                        places.add(place);
                    }
                }
            }
            statement.close();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return places;
    }
}
