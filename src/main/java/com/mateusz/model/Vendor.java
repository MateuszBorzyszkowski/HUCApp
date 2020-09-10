package com.mateusz.model;

public class Vendor {
    private String name;
    private String service;

    public Vendor(String name, String service) {
        this.name = name;
        this.service = service;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    @Override
    public String toString() {
        return name + " => " + service;
    }
}
