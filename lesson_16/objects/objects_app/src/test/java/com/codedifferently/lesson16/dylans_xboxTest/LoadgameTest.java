package com.codedifferently.lesson16.dylans_xboxTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson16.dylans_xbox.LoadGame;
import com.codedifferently.lesson16.dylans_xbox.Xbox;
import java.util.HashMap;
import org.junit.jupiter.api.Test;

public class LoadgameTest {
  @Test
  public void testLoadGame() throws Exception {
    // Create an instance of Xbox
    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, false);

    // Create an instance of LoadGame
    LoadGame loader =
        new LoadGame("src/main/java/com/codedifferently/lesson16/dylans_xbox/data/games.csv");

    loader.loadGamesFromFile(xbox);
    // Check if the game was loaded correctly
    HashMap<Integer, String> games = xbox.getGames();
    assertTrue(games.containsKey(1)); // Check that the first game is loaded (ID 1)
    assertEquals("Call of Duty", games.get(1)); // Ensure the first game matches the CSV
  }
}
