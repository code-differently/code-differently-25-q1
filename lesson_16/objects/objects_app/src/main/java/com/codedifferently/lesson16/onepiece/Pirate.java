package com.codedifferently.lesson16.onepiece;

import java.util.Random;

public class Pirate {
  public enum HakiType {
    Observation,
    Armament,
    Conquerors,
    Advanced_Observation,
    Advanced_Armament,
    Advanced_Conquerors,
    Will_of_D;
  }

  private String name;
  private String crew;
  private long bounty;
  private boolean hasDream;
  private boolean isPirate;
  private HakiType powers;
  private final HakiType[] haki = HakiType.values();
  private static final Random cflip = new Random();

  public Pirate(String name, String crew, long bounty) {
    this.name = name;
    this.crew = crew;
    this.bounty = bounty;
    this.hasDream = true;
    this.isPirate = true;
    this.powers = HakiType.Will_of_D;
  }

  // Getters and setters
  public String getName() {
    return name;
  }

  public String getCrew() {
    return crew;
  }

  public long getBounty() {
    return bounty;
  }

  public boolean getHasDream() {
    return hasDream;
  }

  public boolean getIsPirate() {
    return isPirate;
  }

  public void rollPowers() {
    int randomIndex = cflip.nextInt(haki.length);
    HakiType newHaki = haki[randomIndex];
    powers = newHaki;
    System.out.println("Random Haki: " + powers);
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCrew(String crew) {
    this.crew = crew;
  }

  public void setBounty(Long bounty) {
    this.bounty = bounty;
  }

  public void setHasDream(boolean hasDream) {
    this.hasDream = hasDream;
  }

  public void setIsPirate(boolean isPirate) {
    this.isPirate = isPirate;
  }
}
