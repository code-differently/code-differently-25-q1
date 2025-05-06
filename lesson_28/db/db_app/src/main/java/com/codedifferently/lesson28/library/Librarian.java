package com.codedifferently.lesson28.library;

/** Represents a librarian of a library. */
public class Librarian extends LibraryGuestBase {
  public Librarian(String name, String email) {
    super(name, email);
  }

  @Override
  public String toString() {
    return "Librarian{" + "id='" + getId() + '\'' + ", name='" + getName() + '\'' + '}';
  }
}
