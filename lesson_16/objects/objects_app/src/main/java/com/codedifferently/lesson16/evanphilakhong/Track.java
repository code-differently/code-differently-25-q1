package com.codedifferently.lesson16.evanphilakhong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Track {
    private String trackName;
    private String trackLocation;
    private int numLaps;
    private int trackLengthInKm;
    private boolean drsZone;
    private Weather weather;

    // constructors
    public Track() {
        this.trackName = "";
        this.trackLocation = "";
        this.numLaps = 0;
        this.trackLengthInKm = 0;
        this.drsZone = false;
        this.weather = null;
    }

    public static void main(String[] args) {
        
    }
}