package com.codedifferently.lesson16.comedianstest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.codedifferently.lesson16.comedian.Comedians;
import com.codedifferently.lesson16.comedian.Comedians.ComedyGenre;
import com.codedifferently.lesson16.comedian.InvalidNetWorthException;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComediansTest {

  private Comedians testComedian;

  @BeforeEach
  public void setUp() {
    testComedian =
        new Comedians(
            "Dave Chappelle",
            "USA",
            "1991–present",
            List.of("Killing Them Softly", "Sticks & Stones"),
            50000000,
            Map.of("Instagram", 1000000, "Twitter", 500000),
            true,
            ComedyGenre.SATIRE);
  }

  @Test
  public void testFullName() {
    assertEquals("Dave Chappelle", testComedian.getFullName());
  }

  @Test
  public void testCareerStatus() {
    assertEquals("Still active", testComedian.getCareerStatus());
  }

  @Test
  public void testTotalFollowers() {
    assertEquals(1500000, testComedian.totalFollowers());
  }

  @Test
  public void testFamousWorksSize() {
    assertEquals(2, testComedian.getFamousWorks().size());
  }

  @Test
  public void testInvalidNetWorthThrowsException() {
    Comedians brokeComedian =
        new Comedians(
            "Test Comic",
            "USA",
            "2010–present",
            List.of("Set A"),
            -1000.0,
            Map.of("Instagram", 10000),
            true,
            ComedyGenre.DARK);

    assertThrows(InvalidNetWorthException.class, brokeComedian::validateNetWorth);
  }

  @Test
  public void testPrintFamousWorksOutput() {
    // comments for CH to explain method from chatGPT  Set up to capture System.out
    ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    PrintStream originalOut = System.out;
    System.setOut(new PrintStream(outContent));

    // Call the method
    testComedian.printFamousWorks();

    // Restore original System.out
    System.setOut(originalOut);

    // Expected output (make sure to include newline characters properly)
    String expectedOutput = "Famous Works:\n- Killing Them Softly\n- Sticks & Stones\n";

    // Compare output
    assertEquals(expectedOutput, outContent.toString());
  }

  @Test
  public void testGetNationality() {
    assertEquals("USA", testComedian.getNationality());
  }

  @Test
  public void testGetActiveYears() {
    assertEquals("1991–present", testComedian.getActiveYears());
  }

  @Test
  public void testGetGenre() {
    assertEquals(ComedyGenre.SATIRE, testComedian.getGenre());
  }
}
