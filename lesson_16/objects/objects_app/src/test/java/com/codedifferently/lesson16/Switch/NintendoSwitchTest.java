package com.codedifferently.lesson16.Switch;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codedifferently.lesson16.NintendoSwitch.NintendoSwitch;

public class NintendoSwitchTest {

  private NintendoSwitch mySwitch;

  private ArrayList<String> installedGames;

    public ArrayList<String> getInstalledGames() {
        return installedGames;
    }

  @BeforeEach
  public void setUp() {
    ArrayList<String> preloadGames = new ArrayList<>();
    preloadGames.add("Mario Kart 8 Deluxe");
    preloadGames.add("Splatoon 3");

    mySwitch =
        new NintendoSwitch(
            "SWITCH20250001", NintendoSwitch.Model.STANDARD, false, 3.0, preloadGames);
  }

  @Test
  public void testGetModelAndSerialNumber() {
    assertEquals(NintendoSwitch.Model.STANDARD, mySwitch.getModel());
    assertEquals("SWITCH20250001", mySwitch.getSerialNumber());
  }

  @Test
  public void testCheckBatteryStatus_NoExceptionThrown() {
    assertDoesNotThrow(() -> mySwitch.checkBatteryStatus());
  }

  @Test
  public void testInstallGame() {
    mySwitch.installGame("Metroid Dread");
    assertTrue(mySwitch.getInstalledGames().contains("Metroid Dread"));
  }

  @Test
  public void testDisplayInstalledGames_Output() {
    // This one just ensures method runs without crashing
    assertDoesNotThrow(() -> mySwitch.displayInstalledGames());
  }

  @Test
  public void testSuggestMode() {
    // This one doesn't return anything, so we just check that it doesn't throw
    assertDoesNotThrow(() -> mySwitch.suggestMode());
  }

  @Test
  public void testInvalidBatteryExceptionThrown() {
    ArrayList<String> emptyGames = new ArrayList<>();
    NintendoSwitch brokenSwitch =
        new NintendoSwitch("SWITCH20250002", NintendoSwitch.Model.LITE, false, -1.0, emptyGames);
    assertThrows(
        NintendoSwitch.InvalidBatteryException.class, () -> brokenSwitch.checkBatteryStatus());
  }
}
