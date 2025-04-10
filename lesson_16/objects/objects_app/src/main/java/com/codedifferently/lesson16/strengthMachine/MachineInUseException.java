package com.codedifferently.lesson16.strengthMachine;

public class MachineInUseException extends RuntimeException {
  public MachineInUseException(String message) {
    super(message);
  }
}
