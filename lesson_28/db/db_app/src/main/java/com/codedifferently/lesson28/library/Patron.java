package com.codedifferently.lesson28.library;

/** Represents a patron of a library. */
public class Patron extends LibraryGuestBase {

  /**
   * Create a new patron with the given name and email.
   *
   * @param name The name of the patron.
   * @param email The email of the patron.
   */
  public Patron(String name, String email) {
    super(name, email);
  }

  @Override
  public String toString() {
    return "Patron{" + "id='" + getId() + '\'' + ", name='" + getName() + '\'' + '}';
  }
}
