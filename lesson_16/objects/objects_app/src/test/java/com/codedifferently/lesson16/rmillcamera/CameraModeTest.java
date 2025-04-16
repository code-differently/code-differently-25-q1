package com.codedifferently.lesson16.rmillcamera;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class CameraModeTest {

  @Test
  public void testCameraModeValues() {
    CameraMode[] modes = CameraMode.values();
    assertArrayEquals(
        new CameraMode[] {
          CameraMode.AUTO, CameraMode.MANUAL, CameraMode.PORTRAIT, CameraMode.NIGHT
        },
        modes);
  }
}
