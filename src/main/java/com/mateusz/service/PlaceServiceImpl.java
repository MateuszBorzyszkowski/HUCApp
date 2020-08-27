package com.mateusz.service;

import com.mateusz.api.PlaceDao;
import com.mateusz.api.PlaceService;
import com.mateusz.dao.PlaceDaoImpl;
import com.mateusz.exception.NameInDatabaseAlreadyExistException;
import com.mateusz.exception.NameToRemoveNotExistInDatabaseException;
import com.mateusz.model.Place;

import java.util.List;

public class PlaceServiceImpl implements PlaceService {
    private static PlaceServiceImpl instance = null;
    private PlaceDao placeDao = PlaceDaoImpl.getInstance();

    private PlaceServiceImpl() {}
    public static PlaceServiceImpl getInstance() {
        if (instance == null) {
            instance = new PlaceServiceImpl();
        }
        return instance;
    }

    @Override
    public void addPlace(Place place) throws NameInDatabaseAlreadyExistException {
        if (isPlaceAlreadyExist(place.getName())) {
            throw new NameInDatabaseAlreadyExistException("Place name already exist!");
        }
        placeDao.addPlace(place);
    }

    @Override
    public void removePlaceByName(String placeName) throws NameToRemoveNotExistInDatabaseException {
        if (isPlaceAlreadyExist(placeName)) {
            placeDao.removePlaceByName(placeName);
        } else {
            throw new NameToRemoveNotExistInDatabaseException("No placeName in the database!");
        }
    }

    @Override
    public List<Place> getAllPlaces() {
        return placeDao.getAllPlaces();
    }

    private boolean isPlaceAlreadyExist(String placeName) {
        Place place = getPlaceByName(placeName);

        return place != null;
    }

    private Place getPlaceByName(String placeName) {
        List<Place> places = getAllPlaces();

        for (Place place : places) {
            if (place.getName().equals(placeName)) {
                return place;
            }
        }
        return null;
    }
}
