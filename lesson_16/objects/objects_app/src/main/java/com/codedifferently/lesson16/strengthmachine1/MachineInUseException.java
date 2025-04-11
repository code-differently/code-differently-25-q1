package com.codedifferently.lesson16.strengthmachine1;

public class MachineInUseException extends RuntimeException {
  public MachineInUseException(String message) {
    super(message);
  }
}
