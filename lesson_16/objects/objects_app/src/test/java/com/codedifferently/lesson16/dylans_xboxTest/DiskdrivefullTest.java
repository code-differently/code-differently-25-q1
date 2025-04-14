package com.codedifferently.lesson16.dylans_xboxTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codedifferently.lesson16.dylans_xbox.DiskDriveFullException;
import com.codedifferently.lesson16.dylans_xbox.LoadGame;
import com.codedifferently.lesson16.dylans_xbox.Xbox;
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

    DiskDriveFullException exception =
        assertThrows(
            DiskDriveFullException.class,
            () -> {
              xbox.inputGame(3); // This should trigger the exception
            });

    assertEquals("Disk drive is full. Cannot insert game.", exception.getMessage());
  }
}
