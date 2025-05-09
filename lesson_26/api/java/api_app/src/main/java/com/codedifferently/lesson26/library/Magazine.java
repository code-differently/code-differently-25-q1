package com.codedifferently.lesson26.library;

import java.util.UUID;

/** Represents a magazine. */
public class Magazine extends MediaItemBase {
  public Magazine(UUID id, String title) {
    super(id, title);
  }

  @Override
  public MediaType getType() {
    return MediaType.MAGAZINE;
  }

  @Override
  public boolean canCheckOut() {
    return false;
  }

  @Override
  public String toString() {
    return "Magazine{" + "id='" + getId() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
