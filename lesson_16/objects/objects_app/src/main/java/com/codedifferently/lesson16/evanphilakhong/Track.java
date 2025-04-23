package com.codedifferently.lesson16.evanphilakhong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Track {
  private String trackName;
  private String trackLocation;
  private int numLaps;
  private double trackLengthInKm;
  private boolean drsZone;
  private Weather weather;

  // constructors
  public Track() {
    this.trackName = "Suzuka Circuit";
    this.trackLocation = "Suzuka, Japan";
    this.numLaps = 53;
    this.trackLengthInKm = 5.807;
    this.drsZone = false;
    this.weather = Weather.CLEAR;
  }

  public Track(
      String trackName,
      String trackLocation,
      int numLaps,
      double trackLengthInKm,
      boolean drsZone,
      Weather weather) {
    this.trackName = trackName;
    this.trackLocation = trackLocation;
    this.numLaps = numLaps;
    this.trackLengthInKm = trackLengthInKm;
    this.drsZone = drsZone;
    this.weather = weather;
  }
}
