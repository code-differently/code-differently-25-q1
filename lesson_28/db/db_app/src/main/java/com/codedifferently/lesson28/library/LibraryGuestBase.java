package com.codedifferently.lesson28.library;

import com.codedifferently.lesson28.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson28.library.exceptions.WrongLibraryException;
import java.util.Objects;
import java.util.Set;

/** Base implementation of a library guest. */
public class LibraryGuestBase implements LibraryGuest {

  private Library library;
  private final String name;
  private final String email;

  public LibraryGuestBase(String name, String email) {
    this.name = name;
    this.email = email;
  }

  @Override
  public void setLibrary(Library library) throws WrongLibraryException {
    if (library != null && !library.hasLibraryGuest(this)) {
      throw new WrongLibraryException(
          "Patron " + this.getId() + " is not in library " + library.getId());
    }
    this.library = library;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public String getEmail() {
    return this.email;
  }

  @Override
  public String getId() {
    return this.email;
  }

  @Override
  public Set<MediaItem> getCheckedOutMediaItems() throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for patron " + this.getId());
    }
    return this.library.getCheckedOutByGuest(this);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof LibraryGuestBase)) {
      return false;
    }
    LibraryGuestBase guest = (LibraryGuestBase) o;
    return Objects.equals(getId(), guest.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "LibraryGuestBase{" + "id='" + getId() + '\'' + ", name='" + getName() + '\'' + '}';
  }
}
