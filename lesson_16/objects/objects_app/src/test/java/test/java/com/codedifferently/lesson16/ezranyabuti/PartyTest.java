package test.java.com.codedifferently.lesson16.ezranyabuti;

import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson16.ezranyabuti.Party;
import com.codedifferently.lesson16.ezranyabuti.PartyException;
import com.codedifferently.lesson16.ezranyabuti.Vibe;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class PartyTest {

  @Test
  void testGetName() {
    Party party = new Party();
    Party party2 = new Party();
    Party party3 = new Party();

    String expectedName = "Everyday People";
    String expectedName2 = "Jerk and Jollof";
    String expectedName3 = "Amapiano";

    party.setName(expectedName);
    party2.setName(expectedName2);
    party3.setName(expectedName3);

    String actualName = party.getName();
    String actualName2 = party2.getName();
    String actualName3 = party3.getName();

    assertThat(actualName).isEqualTo(expectedName);
    assertThat(actualName2).isEqualTo(expectedName2);
    assertThat(actualName3).isEqualTo(expectedName3);
  }

  @Test
  void testGetlocalDate() {
    Party party = new Party();
    Party party2 = new Party();
    String expectedLocalDate = "2025-5-01";
    String expectedLocalDate2 = "2025-6-01";
    party.setLocalDate(expectedLocalDate);
    party2.setLocalDate(expectedLocalDate2);
    String actualLocalDate = party.getLocalDate();
    String actualLocalDate2 = party2.getLocalDate();
    assertThat(actualLocalDate).isEqualTo(expectedLocalDate);
    assertThat(actualLocalDate2).isEqualTo(expectedLocalDate2);
  }

  @Test
  void testGetCoverCharge() {
    Party party = new Party();
    double expectedCoverCharge = 20.0;
    party.setCoverCharge(expectedCoverCharge);
    double actualCoverCharge = party.getCoverCharge();
    assertThat(actualCoverCharge).isEqualTo(expectedCoverCharge);
  }

  @Test
  void testGetVibe() {
    Party party = new Party();
    Vibe expectedVibe = Vibe.CHILL;
    party.setVibe(expectedVibe);
    Vibe actualVibe = party.getVibe();
    assertThat(actualVibe).isEqualTo(expectedVibe);
  }

  @Test
  void testSetVibe() {
    Party party = new Party();
    Vibe expectedVibe = Vibe.CHILL;
    party.setVibe(expectedVibe);
    Vibe actualVibe = party.getVibe();
    assertThat(actualVibe).isEqualTo(expectedVibe);
  }

  @Test
  void testSetName() {
    Party party = new Party();
    String expectedName = "Everyday People";
    party.setName(expectedName);
    String actualName = party.getName();
    assertThat(actualName).isEqualTo(expectedName);
  }

  @Test
  void testAddguest() throws PartyException {
    Party party = new Party();
    String expectedGuest = "Meiko";
    String expectedGuest2 = "Ezra";
    String expectedGuest3 = "Bryana";
    String expectedGuest4 = "Justin";
    party.addGuest(expectedGuest);
    party.addGuest(expectedGuest2);
    party.addGuest(expectedGuest3);
    party.addGuest(expectedGuest4);
    ArrayList<String> actualGuestList = party.getGuestList();
    assertThat(actualGuestList).contains(expectedGuest);
    assertThat(actualGuestList).contains(expectedGuest2);
    assertThat(actualGuestList).contains(expectedGuest3);
    assertThat(actualGuestList).contains(expectedGuest4);
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
  void testGetPrivate() {
    Party party = new Party();
    Boolean expectedPrivate = false;
    party.setIsPrivate(expectedPrivate);
    Boolean actualPrivate = party.getIsPrivate();
    assertThat(actualPrivate).isEqualTo(expectedPrivate);
  }

  @Test
  void testCoverCharge() {
    Party party = new Party();
    Double expectedCharge = 50.0;
    party.setCoverCharge(expectedCharge);
    Double actualCharge = party.getCoverCharge();
    assertThat(actualCharge).isEqualTo(expectedCharge);
  }

  @Test
  void testGetTicketNum() {
    Party party = new Party();
    int expectedTicketNum = 10;
    assertThat(party.getTicketNumber()).isEqualTo(expectedTicketNum);
  }

  @Test
  void testSetTicketNum() {
    Party party = new Party();
    int expectedNum = 10;
    party.setTicketNumber(expectedNum);
    int actualTicketNumber = party.getTicketNumber();
    assertThat(actualTicketNumber).isEqualTo(expectedNum);
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
