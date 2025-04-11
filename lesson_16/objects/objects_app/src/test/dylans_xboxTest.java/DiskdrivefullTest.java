package com.codedifferently.lesson16.dylans_xbox;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

public class DiskdrivefullTest {
  @Test
  public void testDiskDriveFullException() throws Exception {
    // Create Xbox with a working disk drive
    Xbox xbox = new Xbox("XBOXSERIESX", 600, "Black", true, false);
    LoadGame loader =
        new LoadGame("src/main/java/com/codedifferently/lesson16/dylans_xbox/data/games.csv");

    loader.loadGamesFromFile(xbox); // Load game library

    // Insert two games to fill the disk drive
    xbox.inputGame(1);
    xbox.inputGame(2);

    try {
      xbox.inputGame(3); // This should trigger the exception
      fail("Expected DiskDriveFullException to be thrown.");
    } catch (DiskDriveFullException e) {
      assertEquals("Disk drive is full. Cannot insert game.", e.getMessage());
    }
  }
}
