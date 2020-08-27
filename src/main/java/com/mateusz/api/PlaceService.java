package com.mateusz.api;

import com.mateusz.exception.NameInDatabaseAlreadyExistException;
import com.mateusz.exception.NameToRemoveNotExistInDatabaseException;
import com.mateusz.model.Place;

import java.util.List;

public interface PlaceService {
    void addPlace(Place place) throws NameInDatabaseAlreadyExistException;
    void removePlaceByName(String placeName) throws NameToRemoveNotExistInDatabaseException;
    List<Place> getAllPlaces();
}
