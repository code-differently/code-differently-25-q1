package com.codedifferently.lesson26.cli;

public enum LibrarySearchCommand {
  UNKNOWN(0),
  RETURN(1),
  TITLE(2),
  AUTHOR(3),
  TYPE(4);

  private final int value;

  LibrarySearchCommand(int value) {
    this.value = value;
  }

  public int getValue() {
    return value;
  }

  public static LibrarySearchCommand fromValue(int value) {
    for (LibrarySearchCommand criteria : LibrarySearchCommand.values()) {
      if (criteria.getValue() == value) {
        return criteria;
      }
    }
    return UNKNOWN;
  }
}
