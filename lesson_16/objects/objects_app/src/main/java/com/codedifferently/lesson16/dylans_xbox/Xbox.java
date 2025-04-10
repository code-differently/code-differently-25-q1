package com.codedifferently.lesson16.dylans_xbox;
import java.util.HashMap;

  /*  
      Create a sub-folder in the main app folder with a unique name for your work.
        Design at least one custom class that represents a real-world object. //Object: Xbox HashMap
          You must also incorporate an enum type as well.
            Genre
          The class must have at least one constructor.
            I have this
          The class must have at least 3 member functions.
            I need this to be added maybe I can do addGame, removeGame, and getGame
          One of your functions must make use of a conditional expression.
            I can do this with the addGame method by implementing a check if the xbox has a disk drive && if the disk drive is empty

          One of your functions must make use of your collection member variable.
            I can do this with the getGame method by calling the games inside of the hashmap

          One of your functions must make use of a loop.
            I can do this with the removeGame method by using a for loop to iterate through the games and remove the game that matches the id passed in.
          You must use at least one custom exception.

            I can do this with the addGame method by creating a custom exception that checks if the disk drive is empty and throws an exception if it is not.
          Create a matching subfolder in the test folder and a test file. Your test must include at least 5 test methods.
            Tests: 
              1. testAddGame
              2. testRemoveGame
              3. testGetGame
              4. testGetAllGames
              5. testGetDiskDrive
   */
public class Xbox {
    private HashMap<Integer, String> games;
    private XboxModel model; //Use the enum type here
    private String color;
    private int price;
    private static final int MAX_GAMES = 10;
    private boolean diskDrive; //Declares if there is a disk drive on the Xbox
    private boolean diskDriveFull; //If there is a disk drive, this will be t/f based on if there is a disk inside the xbox
    //Creates a file path that will call to the games.csv file
    
    //Defines a fixed set of constants for GameGenre
    public enum XboxModel {
        XBOX360,
        XBOXONE,
        XBOXONES,
        XBOXONEX,
        XBOXSERIESS,
        XBOXSERIESX
    }

    public Xbox(String model, int price, String color, boolean diskDrive) {
        this.model = model;
        this.price = price;
        this.color = color;
        this.diskDrive = diskDrive;
        this.games = new HashMap<>();
    }

    public XboxModel getModel() {
        return model;
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
      return DiskDriveFull();
    }

    public void inputGame(int id, String name) throws Exception {

      if(!diskDrive) {
        throw new Exception("This Xbox does not have a disk drive. Cannot insert game.");
      }
      if(diskDriveFull) {
        throw new Exception("Disk drive is full. Cannot insert game.");
      }
        games.put(id, name);
        diskDriveFull = true;
        System.out.println("Game with ID: " + id + " was added to the disk drive.");
        
    }
    
    public void ejectGame(int id) {
      if(games.containsKey(id)) {
        games.remove(id);
        diskDrive = false;
        System.out.println("Game with ID: " + id + " was removed from the disk drive.");
      } else {
        System.out.println("Game with ID: " + id + " not found in the disk drive.");
      }
    }
    
    public void printAllGames() {
      for(Integer id : games.keySet()) {
        System.out.println("Game ID: " + id + ", Game Name: " + games.get(id));
      }
    }



  }

