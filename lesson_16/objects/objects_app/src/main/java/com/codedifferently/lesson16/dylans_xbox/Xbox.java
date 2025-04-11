package com.codedifferently.lesson16.dylans_xbox;

import java.util.HashMap;

public class Xbox {
  private HashMap<Integer, String> games;
  // Declares the model of the Xbox by using the enum XboxModel
  private XboxModel model;
  private String color;
  private int price;
  // Declares if there is a disk drive on the Xbox
  private boolean diskDrive;
  // If there is a disk drive, this will be t/f based on if there is a disk inside of the xbox
  private boolean diskDriveFull = true;

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
    this.diskDriveFull = diskDriveFull;
    this.games = new HashMap<>();
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

  public boolean DiskDriveFull() {
    return diskDriveFull;
  }

  // Method that will add a game to the disk drive
  // it will check if the disk drive is empty and if it is, it will add the game to the disk drive
  // by turnign it to true.
  public void inputGame(int id, String name) throws Exception {

    // These are my custom exceptions that will be thrown if the disk drive is empty or if the disk
    // drive is full.
    if (!diskDrive) {
      throw new Exception("This Xbox does not have a disk drive. Cannot insert game.");
    }
    if (diskDriveFull) {
      throw new DiskDriveFullException("Disk drive is full. Cannot insert game.");
    }

    games.put(id, name);
    diskDriveFull = true;
    System.out.println("Game with ID: " + id + " was added to the disk drive.");
  }

  // Method that will eject a game from the disk drive
  // it will check if the game is in the drive and if it is, it will turn the drive to false.
  public void ejectGame(int id) {
    if (games.containsKey(id)) {
      games.remove(id);
      diskDrive = false;
      System.out.println("Game with ID: " + id + " was removed from the disk drive.");
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

  // This method will remove a game from the HashMap
  public void setDiskDriveFull(boolean b) {
    this.diskDriveFull = b;
  }
}
