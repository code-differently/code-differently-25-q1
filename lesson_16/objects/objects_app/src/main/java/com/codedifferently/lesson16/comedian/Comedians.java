package com.codedifferently.lesson16.comedian;

import java.util.List;
import java.util.Map;

public class Comedians {
  private final String fullName;
  private final String nationality;
  private final String activeYears;
  private final List<String> famousWorks;
  private final double netWorth;
  private final Map<String, Integer> socialMediaFollowers; // e.g., {"Instagram": 1000000}
  private final boolean isStillActive;
  private final ComedyGenre comedyGenre;

  public enum ComedyGenre {
    OBSERVATIONAL,
    SATIRE,
    IMPROV,
    SLAPSTICK,
    DARK,
    PARODY
  }

  public Comedians(
      String fullName,
      String nationality,
      String activeYears,
      List<String> famousWorks,
      double netWorth,
      Map<String, Integer> socialMediaFollowers,
      boolean isStillActive,
      ComedyGenre comedyGenre) {
    this.fullName = fullName;
    this.nationality = nationality;
    this.activeYears = activeYears;
    this.famousWorks = famousWorks;
    this.netWorth = netWorth;
    this.socialMediaFollowers = socialMediaFollowers;
    this.isStillActive = isStillActive;
    this.comedyGenre = comedyGenre;
  }

  public String getFullName() {
    return fullName;
  }

  public String getNationality() {
    return nationality;
  }

  public String getActiveYears() {
    return activeYears;
  }

  public ComedyGenre getGenre() {
    return comedyGenre;
  }

  public List<String> getFamousWorks() {
    return famousWorks;
  }

  public double getNetWorth() {
    return netWorth;
  }

  public Map<String, Integer> getSocialMediaFollowers() {
    return socialMediaFollowers;
  }

  public boolean isStillActive() {
    return isStillActive;
  }

  public void validateNetWorth() throws InvalidNetWorthException {
    if (netWorth < 0) {
      throw new InvalidNetWorthException("Net worth cannot be negative!");
    }
  }

  public String getCareerStatus() {
    return isStillActive ? "Still active" : "Retired";
  }

  public void printFamousWorks() {
    System.out.println("Famous Works:");
    for (String work : famousWorks) {
      System.out.println("- " + work);
    }
  }

  public int totalFollowers() {
    int total = 0;
    for (int count : socialMediaFollowers.values()) {
      total += count;
    }
    return total;
  }
}
