package com.codedifferently.lesson16.hiphopArtist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson16.hiphopArtist.HipHopArtist.Genre;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class HipHopArtistTest {

  @Test
  public void testCheckLegendStatus() {
    // Create a HipHopArtist object
    HipHopArtist artist =
        new HipHopArtist(true, "Kendrick Lamar", 2012, 75_000_000, new ArrayList<>(), Genre.RAP);

    // Check legend status
    String expected = "Kendrick Lamar is a modern star.";
    String actual = artist.checkLegendStatus();

    // Assert the result
    assertEquals(expected, actual);
  }

  @Test
  public void testAddAlbum() {
    // Create a HipHopArtist object
    HipHopArtist artist =
        new HipHopArtist(true, "Kendrick Lamar", 2012, 75_000_000, new ArrayList<>(), Genre.RAP);

    // Add an album
    artist.addAlbum("good kid, m.A.A.d city");

    // Check if the album was added
    assertTrue(artist.getAlbums().contains("good kid, m.A.A.d city"));
  }

  @Test
  public void testIsAlive() {
    // Create a HipHopArtist object
    HipHopArtist artist =
        new HipHopArtist(true, "Kendrick Lamar", 2012, 75_000_000, new ArrayList<>(), Genre.RAP);

    // Check if the artist is alive
    boolean expected = true;
    boolean actual = artist.isAlive();

    // Assert the result
    assertEquals(expected, actual);
  }

  @Test
  public void testGetStageName() {
    // Create a HipHopArtist object
    HipHopArtist artist =
        new HipHopArtist(true, "Kendrick Lamar", 2012, 75_000_000, new ArrayList<>(), Genre.RAP);

    // Get stage name
    String expected = "Kendrick Lamar";
    String actual = artist.getStageName();

    // Assert the result
    assertEquals(expected, actual);
  }

  @Test
  public void testSetAlive() {
    // Create a HipHopArtist object
    HipHopArtist artist =
        new HipHopArtist(true, "Kendrick Lamar", 2012, 75_000_000, new ArrayList<>(), Genre.RAP);

    // Set alive status to false
    artist.setAlive(false);

    // Check if the artist is alive
    boolean expected = false;
    boolean actual = artist.isAlive();

    // Assert the result
    assertEquals(expected, actual);
  }

  @Test
  public void testSetStageName() {
    // Create a HipHopArtist object
    HipHopArtist artist =
        new HipHopArtist(true, "Kendrick Lamar", 2012, 75_000_000, new ArrayList<>(), Genre.RAP);

    // Set stage name
    artist.setStageName("K.Dot");

    // Get stage name
    String expected = "K.Dot";
    String actual = artist.getStageName();

    // Assert the result
    assertEquals(expected, actual);
  }

  @Test
  public void testGetDebutYear() {
    // Create a HipHopArtist object
    HipHopArtist artist =
        new HipHopArtist(true, "Kendrick Lamar", 2012, 75_000_000, new ArrayList<>(), Genre.RAP);

    // Get debut year
    int expected = 2012;
    int actual = artist.getDebutYear();

    // Assert the result
    assertEquals(expected, actual);
  }

  @Test
  public void testSetDebutYear() {
    // Create a HipHopArtist object
    HipHopArtist artist =
        new HipHopArtist(true, "Kendrick Lamar", 2012, 75_000_000, new ArrayList<>(), Genre.RAP);

    // Set debut year
    artist.setDebutYear(2011);

    // Get debut year
    int expected = 2011;
    int actual = artist.getDebutYear();

    // Assert the result
    assertEquals(expected, actual);
  }

  @Test
  public void testGetNetWorth() {
    // Create a HipHopArtist object
    HipHopArtist artist =
        new HipHopArtist(true, "Kendrick Lamar", 2012, 75_000_000, new ArrayList<>(), Genre.RAP);

    // Get net worth
    double expected = 75_000_000;
    double actual = artist.getNetWorth();

    // Assert the result
    assertEquals(expected, actual);
  }

  @Test
  public void testSetNetWorth() {
    // Create a HipHopArtist object
    HipHopArtist artist =
        new HipHopArtist(true, "Kendrick Lamar", 2012, 75_000_000, new ArrayList<>(), Genre.RAP);

    // Set net worth
    artist.setNetWorth(80_000_000);

    // Get net worth
    double expected = 80_000_000;
    double actual = artist.getNetWorth();

    // Assert the result
    assertEquals(expected, actual);
  }
}
