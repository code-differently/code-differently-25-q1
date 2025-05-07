package com.codedifferently.lesson28.library;

import com.codedifferently.lesson28.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson28.library.exceptions.WrongLibraryException;
import com.codedifferently.lesson28.library.search.Searchable;
import java.util.UUID;

/** Represents a media item. */
public interface MediaItem extends Searchable {
  /**
   * Get the type of the media item.
   *
   * @return The type of the media item.
   */
  public String getType();

  /**
   * Get the id of the media item.
   *
   * @return The id of the media item.
   */
  public UUID getId();

  /**
   * Set the library that the media item is in.
   *
   * @param library
   * @throws WrongLibraryException
   */
  public void setLibrary(Library library) throws WrongLibraryException;

  /**
   * Get the title of the media item.
   *
   * @return The title of the media item.
   */
  public String getTitle();

  /**
   * Check if the media item is checked out.
   *
   * @return True if the media item is checked out, false otherwise.
   * @throws LibraryNotSetException
   */
  public boolean isCheckedOut() throws LibraryNotSetException;

  /**
   * Check if the media item can be checked out.
   *
   * @return True if the media item can be checked out, false otherwise.
   */
  public boolean canCheckOut();
}
