package com.codedifferently.lesson26.cli;

public enum LibraryCommand {
  UNKNOWN(0),
  EXIT(1),
  SEARCH(2),
  CHECKOUT(3),
  RETURN(4);

  private final int value;

  LibraryCommand(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static LibraryCommand fromValue(int value) {
    for (LibraryCommand command : LibraryCommand.values()) {
      if (command.getValue() == value) {
        return command;
      }
    }
    return UNKNOWN;
  }
}
