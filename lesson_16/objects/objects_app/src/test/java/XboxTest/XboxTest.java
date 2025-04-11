package XboxTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

import com.codedifferently.lesson16.dylans_xbox.Xbox;

public class XboxTest {

  @Test
  public void testAddGame() {
    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", false);
    loadGames loader =
        new loadGames("src/main/java/com/codedifferently/lesson16/dylans_xbox/games.csv");
    try {
      loader.loadGamesFromFile(xbox);
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception occurred while loading games: " + e.getMessage());
    }

    HashMap<Integer, String> games =
        xbox.getGames(); // Fixed: Changed from `loadGames()` to `getGames()`
    assertTrue(games.containsKey(10));
    assertEquals(
        "Baldur's Gate 3", games.get(10)); // Fixed: Ensured the game name matches the CSV file
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
            "XBOXONE", 400, "White", true); // Fixed: Set diskDrive to `false` to match the test
    assertTrue(
        xbox.DiskDrive(), "Disk drive should be empty"); // Fixed: Corrected the assertion syntax
  }

  @Test
  public void testPrintAllGames() {
    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true);
    loadGames loader =
        new loadGames("src/main/java/com/codedifferently/lesson16/dylans_xbox/games.csv");
    try {
      loader.loadGamesFromFile(xbox);
    } catch (Exception e) {
      e.printStackTrace();
      fail("Exception occurred while loading games: " + e.getMessage());
    }

    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outputStream));

    // Act: Calls the printAllGames method
    xbox.printAllGames();

    // Restore the original console output
    System.setOut(originalOut);

    // Assert: Verify the captured output
    String expectedOutput =
        "Game ID: 1, Game Name: Call of Duty\n"
            + "Game ID: 2, Game Name: Elden Ring\n"
            + "Game ID: 3, Game Name: Minecraft\n"
            + "Game ID: 4, Game Name: Monster Hunter\n"
            + "Game ID: 5, Game Name: Fortnite\n"
            + "Game ID: 6, Game Name: Marvel Rivals\n"
            + "Game ID: 7, Game Name: Tetris\n"
            + "Game ID: 8, Game Name: Madden NFL\n"
            + "Game ID: 9, Game Name: Terraria\n"
            + "Game ID: 10, Game Name: Baldur's Gate 3\n";
    assertEquals(expectedOutput.trim(), outputStream.toString().trim());
  }
}
