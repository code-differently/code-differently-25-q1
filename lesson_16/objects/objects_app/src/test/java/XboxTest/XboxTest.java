package XboxTest;

import java.io.ByteArrayOutputStream; // Ensure LoadGame is imported
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import com.codedifferently.lesson16.dylans_xbox.LoadGame;
import com.codedifferently.lesson16.dylans_xbox.Xbox;

public class XboxTest {

  @Test
  public void testAddGame() {
    LoadGame loader =
        new LoadGame(
            "src/main/java/com/codedifferently/lesson16/dylans_xbox/games.csv"); // Ensure LoadGame

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
    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, true); // Set diskDriveFull to true
    try {
      xbox.inputGame(1, "Call of Duty");
      fail("Expected an exception to be thrown when adding a game to a full disk drive.");
    } catch (Exception e) {
      assertEquals("Disk drive is full. Cannot insert game.", e.getMessage());
    }
  }

  @Test
  public void testXboxModelEnumValues() {
    Xbox.XboxModel[] models = Xbox.XboxModel.values();
    assertEquals(6, models.length);
    assertEquals(
        Xbox.XboxModel.XBOX360, models[0]); // Fixed: Corrected the first model to match the enum
    assertEquals(Xbox.XboxModel.XBOXSERIESX, models[5]);
  }

  @Test
  public void testDiskDrive() {
    Xbox xbox =
        new Xbox(
            "XBOXONE", 400, "White", true,
            false); // Fixed: Set diskDrive to `false` to match the test
    assertTrue(
        xbox.DiskDrive(), "Disk drive should be empty"); // Fixed: Corrected the assertion syntax
  }

  @Test
  public void testPrintAllGames() {
    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, false);
    LoadGame loader =
        new LoadGame("src/main/java/com/codedifferently/lesson16/dylans_xbox/games.csv");
    try {
      loader.loadGamesFromFile(xbox);
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception occurred while loading games: " + e.getMessage());
    }

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
        new LoadGame("src/main/java/com/codedifferently/lesson16/dylans_xbox/games.csv");
    try {
      loader.loadGamesFromFile(xbox);
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception occurred while loading games: " + e.getMessage());
    }

    // Act: Eject a game
    // Act: Eject a game
    xbox.ejectGame(1);

    // Assert: Verify the game was ejected (if needed, check the state of the Xbox object)
    assertTrue(
        !xbox.getGames().containsKey(1), "Game with ID 1 should be removed from the games list.");
  }

  @Test
  public void testGetGames() {

    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, false);
    LoadGame loader =
        new LoadGame("src/main/java/com/codedifferently/lesson16/dylans_xbox/games.csv");

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
}
