package com.codedifferently.lesson16.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.codedifferently.lesson16.player.Player.Type;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class PlayerTest {

  @Test
  public void getName() {
    var expectedName = "JinWhoo";

    Player player1 = new Player("JinWhoo", null, 0, 0, 0, true);

    var actual = player1.getName();

    assertEquals(expectedName, actual);
  }

  @Test
  public void setName() {
    var expectedName = "Montez";

    Player player = new Player("JinWhoo", null, 0, 0, 0, true);

    player.setName(expectedName);

    assertEquals(expectedName, player.getName());
  }

  @Test
  public void getType() {
    Player player1 = new Player(null, Player.Type.DRAGONIOD, 0, 0, 0, true);
    Type expected = Type.DRAGONIOD;
    assertEquals(expected, player1.getType());
  }

  @Test
  public void setType() {
    Player player = new Player(null, Player.Type.HUMAN, 0, 0, 0, true);
    player.setType(Player.Type.ELF);
    assertEquals(Player.Type.ELF, player.getType());
  }

  @Test
  public void getLevel() {
    Player player = new Player(null, null, 5, 0, 0, true);
    assertEquals(5, player.getLevel());
  }

  @Test
  public void setLevel() {
    Player player = new Player(null, null, 1, 0, 0, true);
    player.setLevel(10);
    assertEquals(10, player.getLevel());
  }

  @Test
  public void getCurrentExperience() {
    Player player = new Player(null, null, 0, 150.5, 0, true);
    assertEquals(150.5, player.getCurrentExperience());
  }

  @Test
  public void setCurrentExperience() {
    Player player = new Player(null, null, 0, 0, 0, true);
    player.setCurrentExperiience(200.75);
    assertEquals(200.75, player.getCurrentExperience());
  }

  @Test
  public void getExpPerFight() {
    Player player = new Player(null, null, 0, 0, 50, true);
    assertEquals(50, player.getExpPerFight());
  }

  @Test
  public void setExpPerFight() {
    Player player = new Player(null, null, 0, 0, 0, true);
    player.setExpPerFight(100);
    assertEquals(100, player.getExpPerFight());
  }

  @Test
  public void getIsAlive() {
    Player player = new Player(null, null, 0, 0, 0, true);
    assertTrue(player.getIsAlive());
  }

  @Test
  public void testLevelUpOnce() {
    ArrayList<String> abilities = new ArrayList<>();
    Player player1 = new Player("Jordan", Player.Type.HUMAN, 1, 0, 100, true);

    player1.gainExperience(1); // 1 fight = 100 XP

    assertEquals(2, player1.getLevel()); // Should now be level 2
    assertEquals(0, player1.getCurrentExperience()); // XP resets after exact level up
  }
}

// String name, Type type, int level, double currentExperience, int expPerFight, ArrayList<String>
// unlockedAbilities, boolean isAlive
