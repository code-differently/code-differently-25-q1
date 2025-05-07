import { LibraryGuest } from './library_guest';
import { MediaItem } from './media_item';

export interface Library {
  /**
   * Get the id of the library.
   *
   * @return The id of the library.
   */
  getId(): string;

  /**
   * Check if the library has the given guest.
   *
   * @param guest The guest to check for.
   * @return True if the library has the guest, false otherwise.
   */
  hasLibraryGuest(guest: LibraryGuest): boolean;

  /**
   * Get the items checked out by a guest.
   *
   * @param guest The guest to get the items for.
   * @return The items checked out by the guest.
   */
  getCheckedOutByGuest(guest: LibraryGuest): ReadonlySet<MediaItem>;

  /**
   * Check if the given item is checked out.
   *
   * @param item The item to check.
   * @return True if the item is checked out, false otherwise.
   */
  isCheckedOut(item: MediaItem): boolean;

  /**
   * Check if the library has the given item.
   *
   * @param item The item to check for.
   * @return True if the library has the item, false otherwise.
   */
  hasMediaItem(item: MediaItem): boolean;
}
