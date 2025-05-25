package com.codedifferently.lesson16.davidadenaike;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ShinobiTest {

  @Test
  public void testCreateNormalShinobi() throws RogueShinobiException {
    Shinobi naruto = new Shinobi("Naruto", Village.LEAF, "Genin");

    assertEquals("Naruto", naruto.getName());
    assertEquals("Genin", naruto.getRank());
    assertEquals('D', naruto.getMissionRank());
  }

  @Test
  public void testPromotionEligibility() throws RogueShinobiException {
    Shinobi sasuke = new Shinobi("Sasuke", Village.LEAF, "Genin");

    // Add requirements for Chunin
    sasuke.setMissionRank('A');
    for (int i = 0; i < 5; i++) {
      sasuke.addJutsu("Jutsu" + i);
    }

    assertTrue(sasuke.checkForPromotion());
  }

  @Test
  public void testAddJutsu() throws RogueShinobiException {
    Shinobi kakashi = new Shinobi("Kakashi", Village.LEAF, "Jōnin");

    kakashi.addJutsu("Chidori");
    assertTrue(kakashi.getJutsus().contains("Chidori"));
    assertEquals(1, kakashi.getJutsus().size());
  }

  @Test
  public void testRyoManagement() throws RogueShinobiException {
    Shinobi sakura = new Shinobi("Sakura", Village.LEAF, "Chūnin");

    assertEquals(0, sakura.getRyo());
    sakura.addRyo(1000);
    assertEquals(1000, sakura.getRyo());
  }
}
