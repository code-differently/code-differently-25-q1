package com.codedifferently.lesson16.rmillcamera;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CameraExceptionTest {

  @Test
  public void testExceptionMessage() {
    CameraException ex = new CameraException("Test error message");
    assertEquals("Test error message", ex.getMessage());
  }
}
