package com.codedifferently.lesson16.assassintest;

import static org.assertj.core.api.Assertions.assertThat;

import com.codedifferently.lesson16.assassin.Assassin;
import com.codedifferently.lesson16.assassin.Assassin.Rank;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

public class AssassinTest {
  @Test
  public void testGetRank() {
    Assassin assassin = new Assassin("Ninja", "Sword", 7, Assassin.Rank.MASTER, 700000);
    Rank expected = Rank.MASTER;
    assertThat(assassin.getRank()).isEqualTo(expected);
  }

  @Test
  void testSetWeaponType() {
    Assassin assassin = new Assassin("Marksman", "Sword", 7, Assassin.Rank.MASTER, 700000);
    assassin.setWeaponType("Crossbow");
    String expected = "Crossbow";
    assertThat(assassin.getWeaponType()).isEqualTo(expected);
  }

  @Test
  void testSetPaymentforHire() {
    Assassin assassin = new Assassin("Ninja", "Sword", 7, Assassin.Rank.MASTER, 700000);
    assassin.setPaymentforHire(800000);
    double expected = 800000;
    assertThat(assassin.getPaymentforHire()).isEqualTo(expected);
  }

  @Test
  public void testSetType() {
    Assassin assassin = new Assassin("Ninja", "Sword", 7, Assassin.Rank.MASTER, 700000);
    assassin.setType("Sniper");
    String expected = "Sniper";
    assertThat(assassin.getType()).isEqualTo(expected);
  }

  @Test
  public void testGetPaymentForHire() {
    Assassin assassin = new Assassin("Ninja", "Sword", 7, Assassin.Rank.MASTER, 700000);
    double expected = 700000;
    assertThat(assassin.getPaymentforHire()).isEqualTo(expected);
  }

  @Test
  public void testGetWeaponType() {
    Assassin assassin = new Assassin("Ninja", "Ninja star", 7, Assassin.Rank.MASTER, 700000);
    String expected = "Ninja star";
    assertThat(assassin.getWeaponType()).isEqualTo(expected);
  }

  @Test
  public void testGetType() {
    Assassin assassin = new Assassin("Sniper", "Sniper", 7, Assassin.Rank.MASTER, 700000);
    String expected = "Sniper";
    assertThat(assassin.getType()).isEqualTo(expected);
  }

  @Test
  public void testGetNumberOfTargets() {
    Assassin assassin = new Assassin("Sniper", "Sniper", 7, Assassin.Rank.MASTER, 700000);
    int expected = 7;
    assertThat(assassin.getNumberofTargets()).isEqualTo(expected);
  }

  @Test
  public void testExecuteTarget() throws Exception {
    Assassin assassin = new Assassin("Hitman", "Pistol", 2, Assassin.Rank.ADEPT, 600000);
    assassin.setNumberofTargets(2);
    assassin.executeTarget(2);
    assertThat(assassin.getNumberofTargets()).isEqualTo(2);
  }

  @Test
  public void testGoStealth() {
    Assassin assassin = new Assassin("Ninja", "Sword", 7, Assassin.Rank.LEGEND, 1000000);
    String expected = "Ninja activates stealth mode!";
    assertThat(assassin.goStealth()).isEqualTo(expected);
  }

  @Test
  public void testRankUp() {
    Assassin assassin = new Assassin("Hitman", "Pistol", 3, Assassin.Rank.NOVICE, 500000);
    assassin.rankUp();
    Rank expected = Rank.ADEPT;
    assertThat(assassin.getRank()).isEqualTo(expected);
  }

  @Test
  public void testShowWeapons() {
    Assassin assassin = new Assassin("Hitman", "Pistol", 3, Assassin.Rank.NOVICE, 500000);
    assassin.setWeapons(new ArrayList<>());
    assassin.getWeapons().add("Pistol");
    assassin.getWeapons().add("Dagger");
    assassin.getWeapons().add("Sniper");
    String expected = "Weapons in arsenal:- Pistol- Dagger- Sniper";
    assertThat(assassin.showWeapons()).isEqualTo(expected);
  }
}
