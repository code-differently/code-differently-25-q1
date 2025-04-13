package com.codedifferently.lesson16.onepiece;

import java.util.Random;

public class Pirate {
  public enum HakiType {
    OBSERVATION,
    ARMANENT,
    CONQUERORS,
    ADVANCED_OBSERVATION,
    ADVANCED_ARMANENT,
    ADVANCED_CONQUERORS,
    WILL_OF_D;
  }

  private String name;
  private String crew;
  private Long bounty;
  private String role;
  private Boolean hasDream;
  private HakiType powers;

  private final HakiType[] haki = HakiType.values();
  private static final Random cflip = new Random();

  public Pirate(String name, String crew, Long bounty, String role, Boolean hasDream) {
    this.name = name;
    this.crew = crew;
    this.bounty = bounty;
    this.role = role;
    this.hasDream = true;
    this.powers = HakiType.WILL_OF_D;
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

  public String getRole() {
    return role;
  }

  public boolean getHasDream() throws HasNoDreamException {
    if (!hasDream) {
      throw new HasNoDreamException(name + " has no dream!");
    }
    System.out.println("Has Dream");
    return true;
  }

  public HakiType getPowers() {
    return powers;
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

  public void setRole(String role) {
    this.role = role;
  }

  public void setHasDream(boolean hasDream) {
    this.hasDream = hasDream;
  }
}
