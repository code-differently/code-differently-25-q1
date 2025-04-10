package com.codedifferently.lesson16.PersonalComputer;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ComputerTest {

  private Computer computer;

  @BeforeEach
  public void setUp() {
    computer = new Computer("Dell", "XPS 15", "Intel Core i7", 16, 512, "Windows 11");
  }

  @Test
  public void testPowerOn() throws Computer.ComputerAlreadyOnException {
    assertFalse(computer.isPoweredOn());

    computer.powerOn();

    assertTrue(computer.isPoweredOn());
    assertEquals(Computer.ComputerStatus.ONLINE, computer.getStatus());
  }

  @Test
  public void testPowerOnAlreadyOn() {
    try {
      computer.powerOn();
    } catch (Computer.ComputerAlreadyOnException e) {
      fail("Exception should not be thrown");
    }

    assertThrows(Computer.ComputerAlreadyOnException.class, () -> computer.powerOn());
  }

  @Test
  public void testInstallProgram() {
    // Install a new program
    computer.installProgram("Microsoft Word");

    assertTrue(computer.getInstalledPrograms().contains("Microsoft Word"));
  }

  @Test
  public void testInstallProgramAlreadyInstalled() {
    // Install a program
    computer.installProgram("Google Chrome");

    // Try installing the same program again
    computer.installProgram("Google Chrome");

    // Verify the program is only installed once
    assertEquals(1, computer.getInstalledPrograms().size());
  }

  @Test
  public void testListPrograms() {
    // Capture the printed output
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = new PrintStream(outputStream);
    System.setOut(printStream);

    // Install some programs
    computer.installProgram("Adobe Photoshop");
    computer.installProgram("Visual Studio Code");

    // List the installed programs
    computer.listPrograms();

    // Check if the correct program names are printed
    String output = outputStream.toString();
    assertTrue(output.contains("Adobe Photoshop"));
    assertTrue(output.contains("Visual Studio Code"));
  }

  @Test
  public void testGetters() {
    // Verify that the getters return correct values
    assertEquals("Dell", computer.getBrand());
    assertEquals("XPS 15", computer.getModel());
    assertEquals("Intel Core i7", computer.getCPU());
    assertEquals(16, computer.getRAMGB());
    assertEquals(512, computer.getSTORAGEGB());
  }
}
