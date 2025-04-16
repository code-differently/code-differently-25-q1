package com.codedifferently.lesson16.ezranyabuti;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class PartyTest {

  @Test
  void testGetName() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    String expectedName = "Everyday People";
    party.setName(expectedName);
    String actualName = party.getName();
    assertThat(actualName).isEqualTo(expectedName);
  }

  @Test
  void testGetlocalDate() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    String expectedDate = "2025-06-012";
    party.setLocalDate(expectedDate);
    String actualDate = party.getLocalDate();
    assertThat(actualDate).isEqualTo(expectedDate);
  }

  @Test
  void testGetCoverCharge() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    Double expectedCharge = 50.0;
    party.setCoverCharge(expectedCharge);
    Double actualCharge = party.getCoverCharge();
    assertThat(actualCharge).isEqualTo(expectedCharge);
  }

  @Test
  void testGetVibe() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    Vibe expectedVibe = Vibe.CHILL;
    party.setVibe(expectedVibe);
    Vibe actualVibe = party.getVibe();
    assertThat(actualVibe).isEqualTo(expectedVibe);
  }

  @Test
  void testSetVibe() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
  }

  @Test
  void testSetName() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    String expectedName = "Everyday People";
    party.setName(expectedName);
    String actualName = party.getName();
    assertThat(actualName).isEqualTo(expectedName);
  }

  @Test
  void testSetLocation() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    String expectedLocation = "Brooklyn";
    party.setLocation(expectedLocation);
    String actualLocation = party.getLocation();
    assertThat(actualLocation).isEqualTo(expectedLocation);
  }

  @Test
  void testGetLocation() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    String expectedLocation = "Brooklyn";
    party.setLocation(expectedLocation);
    String actualLocation = party.getLocation();
    assertThat(actualLocation).isEqualTo(expectedLocation);
  }

  @Test
  void testGetPrivate() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    Boolean expectedPrivate = false;
    party.setIsPrivate(expectedPrivate);
    Boolean actualPrivate = party.getIsPrivate();
    assertThat(actualPrivate).isEqualTo(expectedPrivate);
  }

  @Test
  void testSetPrivate() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    Boolean expectedPrivate = true;
    party.setIsPrivate(expectedPrivate);
    Boolean actualPrivate = party.getIsPrivate();
    assertThat(actualPrivate).isEqualTo(expectedPrivate);
  }

  @Test
  void testCoverCharge() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    Double expectedCharge = 50.0;
    party.setCoverCharge(expectedCharge);
    Double actualCharge = party.getCoverCharge();
    assertThat(actualCharge).isEqualTo(expectedCharge);
  }

  @Test
  void testGetTicketNum() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    int expectedNum = 10;
    party.setTicketNumber(expectedNum);
    int actualTicketNumber = party.getTicketNumber();
    assertThat(actualTicketNumber).isEqualTo(expectedNum);
  }

  @Test
  void testSetTicketNum() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    int expectedNum = 10;
    party.setTicketNumber(expectedNum);
    int actualTicketNumber = party.getTicketNumber();
    assertThat(actualTicketNumber).isEqualTo(expectedNum);
  }

  @Test
  void testGuestList() {
    Party party =
        new Party(
            "Everyday People",
            "Washington D.C.",
            "2025-06-012",
            false,
            50.0,
            0,
            Vibe.CHILL,
            new String[] {});
    String[] expectedGuestList = {"Meiko", "Ezra", "Bryana", "Justin"};

    ArrayList<String> guestList = new ArrayList<>(Arrays.asList(expectedGuestList));
    party.setGuestList(guestList);

    ArrayList<String> actualGuestList = party.getGuestList();
    assertThat(actualGuestList).isEqualTo(new ArrayList<>(Arrays.asList(expectedGuestList)));
  }
}
