package com.example.topgamesdata.model;

public class Developer {
    private String name;
    private String country;

    public Developer(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Developer() {

    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
