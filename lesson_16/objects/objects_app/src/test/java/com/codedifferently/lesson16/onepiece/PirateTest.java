package com.codedifferently.lesson16.onepiece;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PirateTest {

  Pirate pirate;

  @BeforeEach
  void setUp() {
    pirate = new Pirate(2, "Zoro", "Swordsman", 900000);
  }

  @Test
  void testGetId() {
    int actual = pirate.getId();

    assertThat(actual).isEqualTo(2);
  }

  @Test
  void testSetId() {
    pirate.setId(3);
    int actual = pirate.getId();

    assertThat(actual).isEqualTo(3);
  }

  @Test
  void testGetName() {
    String actual = pirate.getName();

    assertThat(actual).isEqualTo("Zoro");
  }

  @Test
  void testSetName() {
    pirate.setName("Sanji");
    String actual = pirate.getName();

    assertThat(actual).isEqualTo("Sanji");
  }

  @Test
  void testGetDepartment() {
    String actual = pirate.getDepartment();

    assertThat(actual).isEqualTo("Swordsman");
  }

  @Test
  void testSetDepartment() {
    pirate.setDepartment("Cook");
    String actual = pirate.getDepartment();

    assertThat(actual).isEqualTo("Cook");
  }

  @Test
  void testGetSalary() {
    double actual = pirate.getSalary();

    assertThat(actual).isEqualTo(900000);
  }

  @Test
  void testSetSalary() {
    pirate.setSalary(850000);
    double actual = pirate.getSalary();

    assertThat(actual).isEqualTo(850000);
  }

  @Test
  void testGetDetails() {
    String actual = pirate.getDetails();

    assertThat(actual).isEqualTo("2 Zoro Swordsman 900000.0");
  }
}
