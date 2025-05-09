package com.codedifferently.lesson26.library;

import com.codedifferently.lesson26.library.exceptions.LibraryNotSetException;
import com.codedifferently.lesson26.library.exceptions.WrongLibraryException;
import com.codedifferently.lesson26.library.search.SearchCriteria;
import java.util.Objects;
import java.util.UUID;

/** Base implementation of a media item. */
public abstract class MediaItemBase implements MediaItem {
  private Library library;
  private final UUID id;
  private final String title;

  public MediaItemBase(UUID id, String title) {
    this.id = id;
    this.title = title;
  }

  @Override
  public UUID getId() {
    return id;
  }

  @Override
  public String getTitle() {
    return title;
  }

  @Override
  public void setLibrary(Library library) throws WrongLibraryException {
    if (library != null && !library.hasMediaItem(this)) {
      throw new WrongLibraryException(
          "Media item " + this.getId() + " is not in library " + library.getId());
    }
    this.library = library;
  }

  @Override
  public boolean isCheckedOut() throws LibraryNotSetException {
    if (this.library == null) {
      throw new LibraryNotSetException("Library not set for item " + this.getId());
    }
    return library.isCheckedOut(this);
  }

  @Override
  public boolean canCheckOut() {
    return true;
  }

  /**
   * Check if the media item matches the given author.
   *
   * @param author The author to check.
   * @return True if the media item matches the author, false otherwise.
   */
  protected boolean matchesAuthor(String author) {
    return false;
  }

  @Override
  public boolean matches(SearchCriteria query) {
    if (query.id != null && !this.getId().toString().equalsIgnoreCase(query.id)) {
      return false;
    }
    if (query.title != null && !this.getTitle().toLowerCase().contains(query.title.toLowerCase())) {
      return false;
    }
    if (query.type != null && !this.getType().toString().equalsIgnoreCase(query.type)) {
      return false;
    }
    return query.author == null || this.matchesAuthor(query.author);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof MediaItem)) return false;
    MediaItem item = (MediaItem) o;
    return Objects.equals(getId(), item.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getId());
  }

  @Override
  public String toString() {
    return "MediaItem{" + "id='" + getId() + '\'' + ", title='" + getTitle() + '\'' + '}';
  }
}
