package com.codedifferently.lesson16.strengthmachine;

public class MachineInUseException extends RuntimeException {
  public MachineInUseException(String message) {
    super(message);
  }
}
