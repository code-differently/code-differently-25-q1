package com.codedifferently.lesson16.NintendoSwitch;

import java.util.ArrayList;

public class NintendoSwitch {

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

  public class InvalidBatteryException extends Exception {
    public InvalidBatteryException(String message) {
      super(message);
    }
  }

  public NintendoSwitch(
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

  // Function 1: This will check the battery status.
  public void checkBatteryStatus() throws InvalidBatteryException {
    // Conditional expression checking battery status
    if (batteryLife < 0) {
      throw new InvalidBatteryException("Battery life cannot be negative.");
    }
    System.out.println("Battery life: " + batteryLife + " hours.");
  }

  // Function 2: Adds a game to the installed games collection
  public void installGame(String game) {
    installedGames.add(game);
    System.out.println(game + " has been added to your Nintendo Switch.");
  }

  // Function 3: Displays all installed games using a loop
  public void displayInstalledGames() {
    System.out.println("Installed games on the Nintendo Switch:");
    // Using a loop to iterate over installed games
    for (String game : installedGames) {
      System.out.println("- " + game);
    }
  }

  // Function 4: Checks if the Switch is docked and suggests a mode (using conditional expression)
  public void suggestMode() {
    // Using a conditional expression to suggest a mode
    String mode = isDocked ? "TV mode" : "Handheld mode";
    System.out.println("Your Nintendo Switch is in " + mode + ".");
  }

  // Getter for Model
  public Model getModel() {
    return model;
  }

  // Getter for Serial Number
  public String getSerialNumber() {
    return serialNumber;
  }

  // Main method to test the class
  public static void main(String[] args) {
    // Create an ArrayList to hold installed games
    ArrayList<String> games = new ArrayList<>();
    games.add("Super Mario Odyssey");
    games.add("The Legend of Zelda: Breath of the Wild");

    // This will create a NintendoSwitch object
    NintendoSwitch switchConsole = new NintendoSwitch("SN123456789", Model.OLED, true, 4.5, games);

    try {
      // Test methods
      switchConsole.checkBatteryStatus(); // Check battery life
      switchConsole.installGame("Animal Crossing: New Horizons"); // Install a new game
      switchConsole.displayInstalledGames(); // Display installed games
      switchConsole.suggestMode(); // This suggests whether to use in docked or handheld mode
    } catch (InvalidBatteryException e) {
      System.out.println("Error: " + e.getMessage());
    }
  }
}
