package com.codedifferently.lesson16.nintendoswitch;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class nintendoswitchtest {

  private nintendo ns;
  private ArrayList<String> games;

  @BeforeEach
  void setUp() {
    games = new ArrayList<>();
    ns = new nintendo("SN001", nintendo.Model.STANDARD, true, 5.0, games);
  }

  @Test
  void testInstallGame() {
    ns.installGame("Zelda");

    assertTrue(games.contains("Zelda"), "Game should be installed");
  }

  @Test
  void testCheckBatteryStatusValid() {
    assertDoesNotThrow(
        () -> ns.checkBatteryStatus(),
        "Battery check should not throw an exception for valid battery");
  }

  @Test
  void testCheckBatteryStatusInvalid() {
    nintendo faultySwitch =
        new nintendo("SN002", nintendo.Model.LITE, false, -2.0, new ArrayList<>());

    assertThrows(
        nintendo.InvalidBatteryException.class,
        faultySwitch::checkBatteryStatus,
        "Negative battery should throw InvalidBatteryException");
  }

  @Test
  void testDisplayInstalledGames() {
    games.add("Mario Kart");
    games.add("Smash Bros");

    ByteArrayOutputStream output = new ByteArrayOutputStream();
    System.setOut(new PrintStream(output));

    ns.displayInstalledGames();

    String printedOutput = output.toString();

    assertTrue(printedOutput.contains("Mario Kart"));
    assertTrue(printedOutput.contains("Smash Bros"));

    System.setOut(System.out);
  }

  @Test
  void testInstallMultipleGames() {
    ns.installGame("Animal Crossing");
    ns.installGame("Splatoon");

    assertEquals(2, games.size(), "Two games should be installed");
    assertTrue(games.contains("Animal Crossing"));
    assertTrue(games.contains("Splatoon"));
  }
}
