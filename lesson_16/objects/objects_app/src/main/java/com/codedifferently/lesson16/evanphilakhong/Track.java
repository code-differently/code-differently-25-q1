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
    private boolean isDrsZone;
    private boolean isRaining;

    public static void main(String[] args) {
        
    }
}