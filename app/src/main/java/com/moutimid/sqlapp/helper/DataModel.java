package com.moutimid.sqlapp.helper;

public class DataModel {
    private String name;
    private String address;
    private String details;
    private int image;

    public DataModel(String name, String address, String details, int image) {
        this.name = name;
        this.address = address;
        this.details = details;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDetails() {
        return details;
    }

    public int getImage() {
        return image;
    }
}
