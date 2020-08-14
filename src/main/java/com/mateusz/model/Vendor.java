package com.mateusz.model;

public class Vendor {
    private String name;
    private String utility;

    public Vendor(String name, String utility) {
        this.name = name;
        this.utility = utility;
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
