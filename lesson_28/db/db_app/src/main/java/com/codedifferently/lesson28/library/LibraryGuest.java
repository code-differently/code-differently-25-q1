package com.codedifferently.lesson28.library;

import com.codedifferently.lesson28.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson28.library.exceptions.WrongLibraryException;
import java.util.Set;

public interface LibraryGuest {
  /**
   * Get the library that the guest is in.
   *
   * @param library The library that the guest is in.
   * @throws WrongLibraryException If the guest is not in the library.
   */
  public void setLibrary(Library library) throws WrongLibraryException;

  /**
   * Get the name of the guest.
   *
   * @return The name of the guest.
   */
  public String getName();

  /**
   * Get the email of the guest.
   *
   * @return The email of the guest.
   */
  public String getEmail();

  /**
   * Get the id of the guest.
   *
   * @return The id of the guest.
   */
  public String getId();

  /**
   * Gets the items currently checked out to the guest.
   *
   * @return The items currently checked out to the guest.
   * @throws LibraryNotSetException If the library is not set for the guest.
   */
  public Set<MediaItem> getCheckedOutMediaItems() throws LibraryNotSetException;
}
