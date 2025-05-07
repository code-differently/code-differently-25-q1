package com.codedifferently.lesson26.library;

import java.util.UUID;

/** Represents a newspaper. */
public class Newspaper extends MediaItemBase {
  public Newspaper(UUID id, String title) {
    super(id, title);
  }

  @Override
  public MediaType getType() {
    return MediaType.NEWSPAPER;
  }

  @Override
  public boolean canCheckOut() {
    return false;
  }

  @Override
  public String toString() {
    return "Newspaper{" + "id='" + getId() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
