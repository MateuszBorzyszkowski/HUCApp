package com.mateusz.api;

import com.mateusz.model.Place;

import java.util.List;

public interface PlaceService {
    boolean addPlace(Place place);
    void removePlaceByName(String placeName);
    List<Place> getAllPlaces();
}
