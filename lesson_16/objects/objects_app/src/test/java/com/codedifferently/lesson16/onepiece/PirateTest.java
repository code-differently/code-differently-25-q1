package com.codedifferently.lesson16.onepiece;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson16.onepiece.Pirate.HakiType;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PirateTest {

  Pirate pirate;

  @BeforeEach
  void setUp() {
    pirate = new Pirate("Luffy", "StrawHatPirates", 3000000000L, "Captain", true);
  }

  @Test
  void testGetName() {
    String actual = pirate.getName();

    assertThat(actual).isEqualTo("Luffy");
  }

  @Test
  void testSetName() {
    pirate.setName("BlackBeard");
    String actual = pirate.getName();

    assertThat(actual).isEqualTo("BlackBeard");
  }

  @Test
  void testGetCrew() {
    String actual = pirate.getCrew();

    assertThat(actual).isEqualTo("StrawHatPirates");
  }

  @Test
  void testSetCrew() {
    pirate.setCrew("BlackBeardPirates");
    String actual = pirate.getCrew();

    assertThat(actual).isEqualTo("BlackBeardPirates");
  }

  @Test
  void testGetBounty() {
    Long actual = pirate.getBounty();

    assertThat(actual).isEqualTo(3000000000L);
  }

  @Test
  void testSetBounty() {
    pirate.setBounty(3996000000L);
    Long actual = pirate.getBounty();

    assertThat(actual).isEqualTo(3996000000L);
  }

  @Test
  void testGetRole() {
    String actual = pirate.getRole();

    assertThat(actual).isEqualTo("Captain");
  }

  @Test
  void testSetRole() {
    pirate.setRole("Captain");
    String actual = pirate.getRole();

    assertThat(actual).isEqualTo("Captain");
  }

  @Test
  void testgetHasDream() {
    try {
      pirate.getHasDream();
    } catch (HasNoDreamException e) {
      System.out.println(e.getMessage());
    }
  }

  @Test
  void testRollPowers() {
    pirate.rollPowers();
    assertNotNull(pirate.getPowers(), "Powers should not be null after rolling");
    boolean isValid = false;
    for (HakiType h : HakiType.values()) {
      if (pirate.getPowers() == h) {
        isValid = true;
        break;
      }
    }
    assertTrue(isValid, "Powers should be a valid HakiType");
  }

  @Test
  void testRollPowersOutput() {

    // Capture console output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    System.setOut(new PrintStream(outputStream));

    pirate.rollPowers();

    String output = outputStream.toString().trim();
    boolean matches = false;
    for (HakiType h : HakiType.values()) {
      if (output.equals("Random Haki: " + h)) {
        matches = true;
        break;
      }
    }

    assertTrue(matches, "Haki Options");

    System.setOut(System.out);
  }
}
