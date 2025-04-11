package com.codedifferently.lesson16.evanphilakhong;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Formula1CarTest {

  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  Track track;
  Formula1Car f1Car1;
  Formula1Car f1Car2;

  @BeforeEach
  void setUp() {
    track = new Track();

    String[] f1Car1Sponsors = {"Hp", "Shell", "UniCredit", "IBM", "Puma", "VGW Play"};
    f1Car1 =
        new Formula1Car(Team.FERRARI, f1Car1Sponsors, "Lewis Hamilton", 44, 8, TyreCompound.MEDIUM);
    f1Car1.setTrack(track);

    String[] f1Car2Sponsors = {};
    f1Car2 =
        new Formula1Car(Team.MCLAREN, f1Car2Sponsors, "Lando Norris", 4, 2, TyreCompound.MEDIUM);
    f1Car2.setTrack(track);

    System.setOut(new PrintStream(outContent));
  }

  @AfterEach
  void restoreStreams() {
    System.setOut(System.out);
  }

  @Test
  void testIsDrsAvailibe_returnsTrue() {
    track.setDrsZone(true);

    assertTrue(f1Car1.isDrsAvailible());
  }

  @Test
  void testIsDrsAvailibe_returnsFalse() {
    track.setDrsZone(false);

    assertFalse(f1Car1.isDrsAvailible());
  }

  @Test
  void testRainStrategy_returnsTrue() {
    // checks if tyres change depending on weather conditions
    track.setWeather(Weather.LIGHT_RAIN);
    assertTrue(f1Car1.rainStrategy());
    assertEquals(f1Car1.getCurrTyre(), TyreCompound.INTERMEDIATE);

    track.setWeather(Weather.HEAVY_RAIN);
    assertTrue(f1Car1.rainStrategy());
    assertEquals(f1Car1.getCurrTyre(), TyreCompound.WET);
  }

  @Test
  void testRainStrategy_returnsFalse() {
    // checks the default condition no rain
    assertFalse(f1Car1.rainStrategy());
  }

  @Test
  void testPrintSponsors_withSponsors() throws NoSponsorsException {
    if (f1Car1.getSponsors().length == 0) {
      throw new NoSponsorsException(f1Car1.getTeam() + " has no Sponsors");
    } else {
      String expected =
          "Here's a list of our Sponsors:"
              + System.lineSeparator()
              + "Hp"
              + System.lineSeparator()
              + "Shell"
              + System.lineSeparator()
              + "UniCredit"
              + System.lineSeparator()
              + "IBM"
              + System.lineSeparator()
              + "Puma"
              + System.lineSeparator()
              + "VGW Play"
              + System.lineSeparator();

      f1Car1.printSponsors();

      assertEquals(expected, outContent.toString());
    }
  }

  @Test
  void testPrintSponsors_noSponsors() {
    NoSponsorsException exception =
        assertThrows(NoSponsorsException.class, () -> f1Car2.printSponsors());

    assertEquals(f1Car2.getTeam() + " has no Sponsors", exception.getMessage());
  }
}
