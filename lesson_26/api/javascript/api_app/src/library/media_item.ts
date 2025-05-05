import { Library } from './library';
import { MediaType } from './media_type';
import { Searchable } from './search/searchable';

/** Represents a media item. */
export interface MediaItem extends Searchable {
  /**
   * Get the type of the media item.
   *
   * @return The type of the media item.
   */
  getType(): MediaType;

  /**
   * Get the id of the media item.
   *
   * @return The id of the media item.
   */
  getId(): string;

  /**
   * Set the library that the media item is in.
   *
   * @param library
   * @throws WrongLibraryException
   */
  setLibrary(library: Library): void;

  /**
   * Get the title of the media item.
   *
   * @return The title of the media item.
   */
  getTitle(): string;

  /**
   * Check if the media item is checked out.
   *
   * @return True if the media item is checked out, false otherwise.
   * @throws LibraryNotSetException
   */
  isCheckedOut(): boolean;

  /**
   * Check if the media item can be checked out.
   *
   * @return True if the media item can be checked out, false otherwise.
   */
  canCheckOut(): boolean;
}
