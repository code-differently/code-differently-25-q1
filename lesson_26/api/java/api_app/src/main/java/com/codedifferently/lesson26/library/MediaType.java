package com.codedifferently.lesson26.library;

public enum MediaType {
  UNKNOWN("unknown"),
  BOOK("book"),
  DVD("dvd"),
  MAGAZINE("magazine"),
  NEWSPAPER("newspaper");

  private final String type;

  MediaType(String type) {
    this.type = type;
  }

  public String getType() {
    return type;
  }

  public static MediaType fromString(String type) {
    for (MediaType mediaItemType : MediaType.values()) {
      if (mediaItemType.type.equalsIgnoreCase(type)) {
        return mediaItemType;
      }
    }
    throw new IllegalArgumentException("Invalid media item type: " + type);
  }
}
