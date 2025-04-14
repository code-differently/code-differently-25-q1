package com.codedifferently.lesson16.wardobecollection;

import java.util.ArrayList;

public class ClothingItem {
    // Member variables
    private String name;
    private String type;
    private String color;
    private String size;
    private double value;
    private PersonalCloset.Season season;

    // Constructor
    public ClothingItem (String name, String type, String color, String size, double value, PersonalCloset.Season season) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.size = size;
        this.value = value;
        this.season = season;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public PersonalCloset.Season getSeason() {
        return season;
    }

    public void setSeason(PersonalCloset.Season season) {
        this.season = season;
    }
}