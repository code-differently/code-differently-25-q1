import { Library } from './library';
import { MediaItem } from './media_item';

export interface LibraryGuest {
  /**
   * Set the library that the guest is in.
   *
   * @param library The library that the guest is in.
   * @throws WrongLibraryException If the guest is not in the library.
   */
  setLibrary(library: Library): void;

  /**
   * Get the name of the guest.
   *
   * @return The name of the guest.
   */
  getName(): string;

  /**
   * Get the email of the guest.
   *
   * @return The email of the guest.
   */
  getEmail(): string;

  /**
   * Get the id of the guest.
   *
   * @return The id of the guest.
   */
  getId(): string;

  /**
   * Gets the items currently checked out to the guest.
   *
   * @return The items currently checked out to the guest.
   * @throws LibraryNotSetException If the library is not set for the guest.
   */
  getCheckedOutMediaItems(): ReadonlySet<MediaItem>;
}
