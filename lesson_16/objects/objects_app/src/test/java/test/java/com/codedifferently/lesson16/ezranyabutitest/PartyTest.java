package test.java.com.codedifferently.lesson16.ezranyabutitest;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

import com.codedifferently.lesson16.ezranyabuti.Party;

public class PartyTest {

  @Test
  void testGetName() {
    Party party = new Party();
    String expectedName = "Everyday People";
    
    party.setName(expectedName);
    String actualName = party.getName();
    assertThat(actualName).isEqualTo(expectedName);
  }

  @Test
  void testGetLocation() {
    Party party = new Party();
    String expectedLocation = "Brooklyn";
    party.setLocation(expectedLocation);
    String actualLocation = party.getLocation();
    assertThat(actualLocation).isEqualTo(expectedLocation);
  }

  @Test
  void testGuestList() {
    Party party = new Party();
    String[] expectedGuestList = {"Meiko", "Ezra", "Bryana", "Justin"};

    ArrayList<String> guestList = new ArrayList<>(Arrays.asList(expectedGuestList));
    party.setGuestList(guestList);

    ArrayList<String> actualGuestList = party.getGuestList();
    assertThat(actualGuestList).isEqualTo(new ArrayList<>(Arrays.asList(expectedGuestList)));
  }
}
