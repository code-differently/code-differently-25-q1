package com.codedifferently.lesson16.personcomputer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {

  private Computer computer;

  @BeforeEach
  public void setUp() {
    computer = new Computer("Dell", "Inspiron 15", "Intel Core i7", 16, 512, "Windows 11");
  }

  @Test
  public void testPowerOn() throws Computer.ComputerAlreadyOnException {
    assertFalse(computer.isPoweredOn());

    computer.powerOn();

    assertTrue(computer.isPoweredOn());
    assertEquals(Computer.ComputerStatus.ONLINE, computer.getStatus());
  }

  @Test
  public void testInstallProgram() {
    // Install a new program
    computer.installProgram("Windows 11");

    assertTrue(computer.getInstalledPrograms().contains("Windows 11"));
  }

  @Test
  public void testDuplicateProgramNotInstalledTwice() {
    // Install a program
    computer.installProgram("Google Chrome");

    // Try installing the same program again
    computer.installProgram("Google Chrome");

    // Verify the program is only installed once
    assertEquals(1, computer.getInstalledPrograms().size());
  }

  @Test
  public void testGetters() {
    // Verify that the getters return correct values
    assertEquals("Dell", computer.getBrand());
    assertEquals("Inspiron 15", computer.getModel());
    assertEquals("Intel Core i7", computer.getCPU());
    assertEquals(16, computer.getRAMGB());
    assertEquals(512, computer.getSTORAGEGB());
  }
}
