package com.codedifferently.lesson16.evanphilakhong;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Formula1Car {
  private Track track;
  private Team team;
  private String[] sponsors;
  private String driverName;
  private int driverNum;
  private int position;
  private TyreCompound currTyre;
  private boolean drs;

  /**
   * Default Constructor for a Formula1Car with no team, empty sponsors array, empty driver name,
   * driver number 0, no tyre compound, and DRS is disabled by default
   */
  public Formula1Car() {
    this.team = null;
    this.sponsors = new String[0];
    this.driverName = "";
    this.driverNum = 0;
    this.currTyre = null;
    this.drs = false;
  }

  /**
   * @param team the tean that this Formula1Car belongs
   * @param sponsors array of sponsor names accosicated with this Formula1Car
   * @param driverName the name of the driver of this Formula1Car
   * @param driverNum the drivers number for the Formula1Car
   * @param position drivers current racing position on the grid
   * @param currTyre current TyreCompound fitted on this Formula1Car
   * @see Team
   * @see TyreCompound
   */
  public Formula1Car(
      Team team,
      String[] sponsors,
      String driverName,
      int driverNum,
      int position,
      TyreCompound currTyre) {
    this.team = team;
    this.sponsors = sponsors;
    this.driverName = driverName;
    this.driverNum = driverNum;
    this.position = position;
    this.currTyre = currTyre;
    this.drs = false;
  }

  /**
   * Displays a header line then, Prints a list of sponsors to the console.
   *
   * @throws NoSponsorsException if there are no sponsors associated with this Formula1Car
   * @see NoSponsorsException
   */
  public void printSponsors() throws NoSponsorsException {
    if (sponsors.length == 0) {
      throw new NoSponsorsException(team + " has no Sponsors");
    } else {
      System.out.println("Here's a list of our Sponsors:");
      for (String sponsor : sponsors) {
        System.out.println(sponsor);
      }
    }
  }

  /**
   * Checks if DRS (Drag Reduction System) is availible to use This method determines DRS
   * availibility based on weather or not your Formula1Car is in the current track's designated DRS
   * zone.
   *
   * @return {@code true} if DRS is availible (track has a DRS zone), {@code false} otherwise
   * @see Track#isDrsZone()
   */
  public boolean isDrsAvailible() {
    if (track.isDrsZone()) {
      this.drs = true;
      return true;
    }
    return false;
  }

  /**
   * Checks if we need to switch race strategy to account for the rainy weather if the weather is
   * LIGHT_RAIN we change the TyreCompound to INTERMEDIATE if the weather is HEAVY_RAIN we change
   * the TyreCompound to WET
   *
   * @return {@code true} if track.getWeather is LIGHT_RAIN || HEAVY_RAIN {@code false} otherwise
   * @see Track#getWeather()
   */
  public boolean rainStrategy() {
    if (track.getWeather() == Weather.LIGHT_RAIN) {
      this.currTyre = TyreCompound.INTERMEDIATE;
      return true;
    } else if (track.getWeather() == Weather.HEAVY_RAIN) {
      this.currTyre = TyreCompound.WET;
      return true;
    }
    return false;
  }
}
