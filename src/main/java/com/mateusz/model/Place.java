package com.mateusz.model;

public class Place {
    private String name;
    private String street;
    private String homeNumber;
    private String postalCode;
    private String city;

    public Place(String name, String street, String homeNumber, String postalCode, String city) {
        this.name = name;
        this.street = street;
        this.homeNumber = homeNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " => " +
                street + " " +
                homeNumber + ", " +
                postalCode + " " +
                city;
    }
}
