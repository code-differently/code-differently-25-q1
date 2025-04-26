package com.codedifferently.lesson16.nintendoswitch;

import java.util.ArrayList;

public class nintendo {

  public enum Model {
    STANDARD,
    LITE,
    OLED
  }

  // This will be the attributes, or member variables, of the NintendoSwitch class.
  private String serialNumber;
  private Model model;
  private boolean isDocked;
  private double batteryLife; // This will be in hours.
  private ArrayList<String> installedGames;

  // This will be the constructor for the NintendoSwitch class.
  public nintendo(
      String serialNumber,
      Model model,
      boolean isDocked,
      double batteryLife,
      ArrayList<String> installedGames) {
    this.serialNumber = serialNumber;
    this.model = model;
    this.isDocked = isDocked;
    this.batteryLife = batteryLife;
    this.installedGames = installedGames;
  }

  public class InvalidBatteryException extends Exception {
    public InvalidBatteryException(String message) {
      super(message);
    }
  }

  /** Function 1: This will check the battery status. This also has the exception handling. */
  public void checkBatteryStatus() throws InvalidBatteryException {
    /** Conditional expression checking battery status */
    if (batteryLife < 0) {
      throw new InvalidBatteryException("Battery life cannot be negative.");
    }
    System.out.println("Battery life: " + batteryLife + " hours.");
  }

  /** Function 2: Adds a game to the installed games collection */
  public void installGame(String game) {
    installedGames.add(game);
    System.out.println(game + " has been added to your Nintendo Switch.");
  }

  /** Function 3: Displays all installed games using a loop */
  public void displayInstalledGames() {
    System.out.println("Installed games on the Nintendo Switch:");
    /** Using a normal for loop to iterate over installed games */
    for (int i = 0; i < installedGames.size(); i++) {
      System.out.println("- " + installedGames.get(i));
    }
  }

  /** Getter methods */
  public String getSerialNumber() {
    return serialNumber;
  }

  public Model getModel() {
    return model;
  }

  public boolean isDocked() {
    return isDocked;
  }

  public double getBatteryLife() {
    return batteryLife;
  }

  public ArrayList<String> getInstalledGames() {
    return installedGames;
  }
}
