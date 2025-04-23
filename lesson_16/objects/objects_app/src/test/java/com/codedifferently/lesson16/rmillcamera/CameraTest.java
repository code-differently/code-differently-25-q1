package com.codedifferently.lesson16.rmillcamera;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CameraTest {

  private Camera camera;

  @BeforeEach
  public void setUp() {
    camera = new Camera("Canon", 20, 750.00, CameraMode.AUTO);
  }

  @Test
  public void testAddValidFormat() throws CameraException {
    camera.addFormat("PNG");
  }

  @Test
  public void testAddEmptyFormatThrowsException() {
    Exception exception = assertThrows(CameraException.class, () -> camera.addFormat(""));
    assertEquals("Format cannot be empty.", exception.getMessage());
  }

  @Test
  public void testAddNullFormatThrowsException() {
    Exception exception = assertThrows(CameraException.class, () -> camera.addFormat(null));
    assertEquals("Format cannot be empty.", exception.getMessage());
  }

  @Test
  public void testIsAffordableWithinBudget() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    camera.isAffordable(800);
    String result = out.toString().trim();
    assertTrue(result.contains("within your budget"));
  }

  @Test
  public void testIsAffordableOverBudget() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    camera.isAffordable(500);
    String result = out.toString().trim();
    assertTrue(result.contains("too expensive"));
  }

  @Test
  public void testIsAffordableAtExactBudget() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    camera.isAffordable(750.00);
    String result = out.toString().trim();
    assertTrue(result.contains("within your budget"));
  }

  @Test
  public void testShowFormatsWhenEmpty() {
    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    camera.showFormats();
    String result = out.toString().trim();
    assertTrue(result.contains("No formats supported yet."));
  }

  @Test
  public void testShowFormatsWithValues() throws CameraException {
    camera.addFormat("JPEG");
    camera.addFormat("RAW");

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    System.setOut(new PrintStream(out));

    camera.showFormats();
    String result = out.toString();
    assertTrue(result.contains("Supported formats"));
    assertTrue(result.contains("JPEG"));
    assertTrue(result.contains("RAW"));
  }

  @Test
  public void testConstructorSetsValuesCorrectly() throws Exception {
    Camera cam = new Camera("Nikon", 24, 900.0, CameraMode.MANUAL);

    var brandField = cam.getClass().getDeclaredField("brand");
    var priceField = cam.getClass().getDeclaredField("price");

    brandField.setAccessible(true);
    priceField.setAccessible(true);

    assertEquals("Nikon", brandField.get(cam));
    assertEquals(900.0, priceField.get(cam));
  }
}
