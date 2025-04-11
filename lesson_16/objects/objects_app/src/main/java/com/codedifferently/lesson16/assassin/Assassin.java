package com.codedifferently.lesson16.assassin;

import java.util.ArrayList;

public class Assassin {
  private String type;
  private String weaponType;
  private int numberofTargets;
  private ArrayList<String> weapons;
  private double paymentforHire;
  private Rank rank;

  public Assassin(
      String type, String weaponType, int numberofTargets, Rank rank, int paymentforHire) {
    this.type = type;
    this.weaponType = weaponType;
    this.numberofTargets = numberofTargets;
    this.weapons = new ArrayList<>();
    this.paymentforHire = paymentforHire;
    this.rank = rank;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getWeaponType() {
    return weaponType;
  }

  public void setWeaponType(String weaponType) {
    this.weaponType = weaponType;
  }

  public int getNumberofTargets() {
    return numberofTargets;
  }

  public void setNumberofTargets(int numberofTargets) {
    this.numberofTargets = numberofTargets;
  }

  public ArrayList<String> getWeapons() {
    return weapons;
  }

  public void setWeapons(ArrayList<String> weapons) {
    this.weapons = weapons;
  }

  public double getPaymentforHire() {
    return paymentforHire;
  }

  public void setPaymentforHire(double paymentforHire) {
    this.paymentforHire = paymentforHire;
  }

  public Rank getRank() {
    return rank;
  }

  public void setRank(Rank rank) {
    this.rank = rank;
  }

  public enum Rank {
    NOVICE,
    ADEPT,
    MASTER,
    GRANDMASTER,
    LEGEND
  }

  public void executeTarget(int numberofTargets) throws NoTargetsException {
    if (numberofTargets < 0) {
      throw new NoTargetsException("Number of targets cannot be negative.");
    }
    if (numberofTargets == 0) {
      System.out.println("No targets to eliminate!");
    }
    for (int i = 0; i < numberofTargets; i++) {
      System.out.println("Target " + i + " eliminated!");
    }
  }

  public String goStealth() {
    return type + " activates stealth mode!";
  }

  public void rankUp() {
    switch (rank) {
      case NOVICE -> rank = Rank.ADEPT;
      case ADEPT -> rank = Rank.MASTER;
      case MASTER -> rank = Rank.GRANDMASTER;
      case GRANDMASTER -> rank = Rank.LEGEND;
      case LEGEND -> {
        System.out.println(type + " is already at the highest rank: Legend.");
        return;
      }
    }
    System.out.println(type + " has been promoted to " + rank + " rank!");
  }

  public String showWeapons() {
    String result = "Weapons in arsenal:";
    for (String weapon : weapons) {
      result += "- " + weapon;
    }
    return result;
  }
}
