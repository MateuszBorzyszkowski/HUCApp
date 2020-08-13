package com.mateusz.model;

public class Vendor {
    private int id;
    private String name;
    private String utility;

    public Vendor(int id, String name, String utility) {
        this.id = id;
        this.name = name;
        this.utility = utility;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUtility() {
        return utility;
    }

    public void setUtility(String utility) {
        this.utility = utility;
    }
}
