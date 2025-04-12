package com.codedifferently.lesson16.personcomputer;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ComputerStatusTest {

  @Test
  void testEnumValues() {
    Computer.ComputerStatus[] statuses = Computer.ComputerStatus.values();
    assertEquals(4, statuses.length);
    assertArrayEquals(
        new Computer.ComputerStatus[] {
          Computer.ComputerStatus.OFFLINE,
          Computer.ComputerStatus.ONLINE,
          Computer.ComputerStatus.SLEEP,
          Computer.ComputerStatus.SHUTDOWN
        },
        statuses);
  }

  @Test
  void testValueOf() {
    assertEquals(Computer.ComputerStatus.ONLINE, Computer.ComputerStatus.valueOf("ONLINE"));
  }
}
