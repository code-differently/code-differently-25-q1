package com.codedifferently.lesson16.nintendoswitch;

import java.util.ArrayList;

public class nintendo {

  public enum Model {
    STANDARD,
    LITE,
    OLED
  }

  private String serialNumber;
  private Model model;
  private boolean isDocked;
  private double batteryLife; // This will be in hours.
  private ArrayList<String> installedGames;

  /**
   * Constructs a Nintendo Switch object with the specified attributes.
   *
   * @param serialNumber   serial number of the device
   * @param model          the model type of the Nintendo Switch
   * @param isDocked       indicates if the device is currently docked
   * @param batteryLife    current battery life in hours
   * @param installedGames list of games currently installed on the device
   */
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


  /**
   * Checks the current battery status of the Nintendo Switch.
   * If the battery life is negative, it throws an InvalidBatteryException.
   *
   * @throws InvalidBatteryException if battery life is less than 0
   */
  public void checkBatteryStatus() throws InvalidBatteryException {
    if (batteryLife < 0) {
      throw new InvalidBatteryException("Battery life cannot be negative.");
    }
    System.out.println("Battery life: " + batteryLife + " hours.");
  }

  /**
   * Installs a game to the Nintendo Switch.
   *
   * @param game the name of the game to install
   */
  public void installGame(String game) {
    installedGames.add(game);
    System.out.println(game + " has been added to your Nintendo Switch.");
  }

  /**
   * Displays all the games currently installed on the Nintendo Switch.
   */
  public void displayInstalledGames() {
    System.out.println("Installed games on the Nintendo Switch:");
    /** Using a normal for loop to iterate over installed games */
    for (int i = 0; i < installedGames.size(); i++) {
      System.out.println("- " + installedGames.get(i));
    }
  }

  /* Getter methods */
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
