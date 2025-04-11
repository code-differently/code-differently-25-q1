package com.codedifferently.lesson16.dylans_xbox;

import java.util.ArrayList;
import java.util.HashMap;

public class Xbox {
  private ArrayList<String> insertedGames = new ArrayList<>();
  private HashMap<Integer, String> games;
  // Declares the model of the Xbox by using the enum XboxModel
  private XboxModel model;
  private String color;
  private int price;
  // Declares if there is a disk drive on the Xbox
  private boolean diskDrive = false;

  // Defines a fixed set of constants for GameGenre
  public enum XboxModel {
    XBOX360,
    XBOXONE,
    XBOXONES,
    XBOXONEX,
    XBOXSERIESS,
    XBOXSERIESX
  }

  // Constructor for the Xbox class
  public Xbox(String model, int price, String color, boolean diskDrive, boolean diskDriveFull) {
    this.model = XboxModel.valueOf(model.toUpperCase());
    this.price = price;
    this.color = color;
    this.diskDrive = diskDrive;
    this.insertedGames = new ArrayList<>();
    this.games = new HashMap<>();
  }

  public int getInsertedGamesSize() {
    return insertedGames.size();
  }

  // Getters for the Xbox class
  public XboxModel getModel() {
    return model;
  }

  public HashMap<Integer, String> getGames() {
    return games;
  }

  public int getPrice() {
    return price;
  }

  public String getColor() {
    return color;
  }

  public boolean DiskDrive() {
    return diskDrive;
  }

  // Method that will add a game to the disk drive
  // it will check if the disk drive is empty and if it is, it will add the game to the disk drive
  // by turning it to true.
  public void inputGame(int id) throws Exception {
    if (!diskDrive) {
      throw new Exception("This Xbox does not have a disk drive. Cannot insert game.");
    }
    if (insertedGames.size() >= 2) {
      throw new DiskDriveFullException("Disk drive is full. Cannot insert game.");
    }

    String gameName = games.get(id);
    if (gameName == null) {
      throw new Exception("Game with ID: " + id + " does not exist in the library.");
    }
    if (insertedGames.contains(gameName)) {
      throw new Exception("Game \"" + gameName + "\" is already inserted.");
    }

    insertedGames.add(gameName);
    games.remove(id);

    System.out.println("Game \"" + gameName + "\" (ID: " + id + ") was added to the disk drive.");
  }

  // Method that will eject a game from the disk drive
  // it will check if the game is in the drive and if it is, it will turn the drive to false.
  public void ejectGame(int id) {
    if (insertedGames.size() >= 1) {
      insertedGames.removeAll(insertedGames);
      System.out.println("Game with ID: " + id + " was ejected from the disk drive.");
    } else {
      System.out.println("Game with ID: " + id + " not found in the disk drive.");
    }
  }

  // This method will print all the games in the HashMap
  // By running a for loop that will iterate through the games
  public void printAllGames() {
    for (Integer id : games.keySet()) {
      System.out.println("Game ID: " + id + ", Game Name: " + games.get(id));
    }
  }
}
