package com.codedifferently.lesson16.personcomputer;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ComputerAlreadyOnExceptionTest {

  @Test
  void testExceptionMessage() {
    String message = "Computer is already powered on.";
    Computer.ComputerAlreadyOnException exception =
        new Computer(message, message, message, 0, 0, message)
        .new ComputerAlreadyOnException(message);
    assertEquals(message, exception.getMessage());
  }

  @Test
  void testPowerOnThrowsException() throws Exception {
    Computer computer = new Computer("Dell", "XPS", "Intel", 8, 256, "");
    computer.powerOn();

    Exception exception =
        assertThrows(Computer.ComputerAlreadyOnException.class, computer::powerOn);

    assertEquals("Computer is already powered on.", exception.getMessage());
  }
}
