package com.codedifferently.lesson16.dylans_xboxTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.codedifferently.lesson16.dylans_xbox.DiskDriveFullException;
import com.codedifferently.lesson16.dylans_xbox.LoadGame;
import com.codedifferently.lesson16.dylans_xbox.Xbox;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import org.junit.jupiter.api.Test; // Ensure LoadGame is imported

public class XboxTest {

  @Test
  public void testAddGame() {
    LoadGame loader =
        new LoadGame(
            "src/main/java/com/codedifferently/lesson16/dylans_xbox/data/games.csv"); // Ensure
    // LoadGame

    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, false); // Create an instance of Xbox
    try {
      loader.loadGamesFromFile(xbox);
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception occurred while loading games: " + e.getMessage());
    }

    HashMap<Integer, String> games = xbox.getGames();
    assertTrue(games.containsKey(1)); // Check that the first game is loaded (ID 1)
    assertEquals("Call of Duty", games.get(1)); // Ensure the first game matches the CSV
  }

  @Test
  public void testAddGameIfFull() {
    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, false); // false means not full yet
    LoadGame loader =
        new LoadGame("src/main/java/com/codedifferently/lesson16/dylans_xbox/data/games.csv");

    try {
      loader.loadGamesFromFile(xbox);

      // Insert two games (disk limit)
      xbox.inputGame(1);
      xbox.inputGame(2);

      // This third insert should throw an exception
      xbox.inputGame(3);
      fail("Expected DiskDriveFullException to be thrown.");
    } catch (DiskDriveFullException e) {
      assertEquals("Disk drive is full. Cannot insert game.", e.getMessage());
    } catch (Exception e) {
      e.printStackTrace();
      fail("Unexpected exception: " + e.getMessage());
    }
  }

  @Test
  public void testXboxModelEnumValues() {
    Xbox.XboxModel[] models = Xbox.XboxModel.values();
    assertEquals(6, models.length);
    assertEquals(Xbox.XboxModel.XBOX360, models[0]);
    assertEquals(Xbox.XboxModel.XBOXSERIESX, models[5]);
  }

  @Test
  public void testPrintAllGames() throws Exception {
    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, false);
    LoadGame loader =
        new LoadGame("src/main/java/com/codedifferently/lesson16/dylans_xbox/data/games.csv");

    loader.loadGamesFromFile(xbox); // Load games into library

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    xbox.printAllGames();

    System.setOut(originalOut);

    String expectedOutput =
        """
            Game ID: 1, Game Name: Call of Duty
            Game ID: 2, Game Name: Elden Ring
            Game ID: 3, Game Name: Minecraft
            Game ID: 4, Game Name: Monster Hunter
            Game ID: 5, Game Name: Fortnite
            Game ID: 6, Game Name: Marvel Rivals
            Game ID: 7, Game Name: Tetris
            Game ID: 8, Game Name: Madden NFL
            Game ID: 9, Game Name: Terraria
            Game ID: 10, Game Name: Baldur's Gate 3
            """;
    assertEquals(expectedOutput.trim(), outputStream.toString().trim());
  }

  @Test
  public void testEjectGame() {
    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, false);
    LoadGame loader =
        new LoadGame("src/main/java/com/codedifferently/lesson16/dylans_xbox/data/games.csv");

    try {
      loader.loadGamesFromFile(xbox); // Load games into library
      xbox.inputGame(1); // Insert game with ID 1
      assertEquals(1, xbox.getInsertedGamesSize(), "Game should be inserted.");

      xbox.ejectGame(1); // Eject by name (you may use ID instead if implemented that way)
      assertEquals(0, xbox.getInsertedGamesSize(), "The game should be ejected.");
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception occurred: " + e.getMessage());
    }
  }

  @Test
  public void testGetGames() {

    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, false);
    LoadGame loader =
        new LoadGame("src/main/java/com/codedifferently/lesson16/dylans_xbox/data/games.csv");

    try {
      loader.loadGamesFromFile(xbox);
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception occurred while loading games: " + e.getMessage());
    }

    HashMap<Integer, String> games = xbox.getGames();

    assertEquals(10, games.size(), "There should be 10 games loaded.");
  }

  @Test
  public void testGetPrice() {
    Xbox xbox = new Xbox("XBOX360", 400, "White", true, false);
    int price = xbox.getPrice();
    assertEquals(400, price, "The price should be 400.");
  }

  @Test
  public void testGetColor() {
    Xbox xbox = new Xbox("XBOX360", 400, "White", true, false);
    String color = xbox.getColor();
    assertEquals("White", color, "The color should be White.");
  }

  @Test
  public void testDiskDrive() {
    Xbox xbox = new Xbox("XBOX360", 400, "White", true, false);
    boolean diskDrive = xbox.DiskDrive();
    assertTrue(diskDrive, "The disk drive should be present.");
  }
}
