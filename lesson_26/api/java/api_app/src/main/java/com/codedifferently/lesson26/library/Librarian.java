package com.codedifferently.lesson26.library;

import java.util.List;
import java.util.UUID;

/** Represents a librarian of a library. */
public class Librarian extends LibraryGuestBase {
  public Librarian(String name, String email) {
    super(name, email);
  }

  @Override
  public String toString() {
    return "Librarian{" + "id='" + getEmail() + '\'' + ", name='" + getName() + '\'' + '}';
  }

  public MediaItem getItem(String id) {
    try {
      return getLibrary().findById(id);
    } catch (Exception e) {
      return null;
    }
  }

  public void removeItem(String id) {
    getLibrary().deleteById(id);
  }

  public MediaItem createItem(String title, String type, String genre, String author) {
    UUID id = UUID.randomUUID();
    MediaItem item;

    switch (type.toLowerCase()) {
      case "book" -> item = new Book(id, title, "1234567890", List.of(author), 100);
      case "dvd" -> item = new Dvd(id, title);
      case "magazine" -> item = new Magazine(id, title);
      case "newspaper" -> item = new Newspaper(id, title);
      default -> throw new IllegalArgumentException("Unknown media type: " + type);
    }

    item.setLibrary(getLibrary());
    getLibrary().addItem(item);
    return item;
  }
}
